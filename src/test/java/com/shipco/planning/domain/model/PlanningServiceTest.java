package com.shipco.planning.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.shipco.planning.domain.model.DateRangeFunctions.*;
import static com.shipco.planning.domain.model.PortInfrastructure.*;
import static com.shipco.planning.domain.model.TestData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PlanningServiceTest {

    TestInMemoryPlanningRepository planningRepository;
    OffloadingDurationCalculator offloadingDurationCalculator;
    PlanningService planningService;

    @BeforeEach
    void setUp() {
        planningRepository = new TestInMemoryPlanningRepository(planningWithNoReservation());
        offloadingDurationCalculator = mock(OffloadingDurationCalculator.class);
        planningService = new PlanningService(planningRepository, offloadingDurationCalculator);

        when(offloadingDurationCalculator.calculateOffloadingDuration(vesselId)).thenReturn(Duration.ofHours(2));
    }

    @Test
    void it_can_reserve_a_quay_if_no_prior_reservation_exists() {
        var originalPlanning = planningWithNoReservation();
        planningRepository.resetPlanning(copy(originalPlanning));

        var optReservation = planningService.reserveQuay(vesselId, vesselEstimatedArrivalDate);

        assertTrue(optReservation.isPresent());
        var planning = planningRepository.getSavedPlanning();
        assertPlanningChanged(originalPlanning, planning, 1);
        assertAddedReservation(planning, getQuaysId());
    }

    @Test
    void it_can_reserve_a_quay_if_a_quay_is_available() {
        var originalPlanning = planningWithSomeReservations();
        planningRepository.resetPlanning(copy(originalPlanning));

        var optReservation = planningService.reserveQuay(vesselId, vesselEstimatedArrivalDate);

        assertTrue(optReservation.isPresent());
        var planning = planningRepository.getSavedPlanning();
        assertPlanningChanged(originalPlanning, planning, 1);
        assertAddedReservation(planning, List.of(quay4.getId(), quay5.getId()));
    }

    @Test
    void it_cant_reserve_a_quay_if_no_quay_is_available() {
        var originalPlanning = planningWithFullReservations();
        planningRepository.resetPlanning(copy(originalPlanning));

        var optReservation = planningService.reserveQuay(vesselId, vesselEstimatedArrivalDate);

        assertTrue(optReservation.isEmpty());
        var planning = planningRepository.getSavedPlanning();
        assertPlanningChangedUnchanged(originalPlanning, planning);
    }

    private static void assertPlanningChangedUnchanged(Planning originalPlanning, Planning planning) {
        assertPlanningChanged(originalPlanning, planning, 0);
    }

    private static void assertPlanningChanged(Planning originalPlanning, Planning planning, int expectedAddedReservations) {
        assertThat("expected same planningId", planning.getId(), equalTo(originalPlanning.getId()));
        var addedReservations = planning.getReservations().size() - originalPlanning.getReservations().size();
        assertThat("expected same number of reservations", addedReservations, equalTo(expectedAddedReservations));
    }

    private static void assertAddedReservation(Planning planning, List<UUID> quayIdPossibilities) {
        var reservation = planning.getReservations().get(planning.getReservations().size() - 1);
        assertThat("expected same vesselId", reservation.getVesselId(), equalTo(vesselId));
        assertThat("expected same timeSlot", reservation.getTimeSlot(), equalTo(range(vesselEstimatedArrivalDate, vesselEstimatedArrivalDate.plusHours(2))));
        assertTrue(quayIdPossibilities.contains(reservation.getQuayId()));
    }

    private Planning copy(Planning planning) {
        return new Planning(
                planning.getId(),
                planning.getYear(),
                planning.getMonth(),
                planning.getReservations().stream()
                        .map(this::copy)
                        .collect(Collectors.toList())
            );
    }

    private Reservation copy(Reservation reservation) {
        return new Reservation(
                reservation.getId(),
                reservation.getVesselId(),
                reservation.getQuayId(),
                reservation.getTimeSlot()
            );
    }
}