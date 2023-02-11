package com.shipco.planning.application;

import com.shipco.planning.domain.model.PlanningService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static com.shipco.planning.domain.model.TestData.reserveQuay;
import static com.shipco.planning.domain.model.TestData.vesselId;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PlanningApplicationTest {

    PlanningService planningService;

    PlanningApplication planningApplication;

    @BeforeEach
    void setUp() {
        planningService = mock(PlanningService.class);
        planningApplication = new PlanningApplication(planningService);
    }

    @Test
    void it_reserves_a_quay() {
        planningApplication.reserveQuay(reserveQuay);

        verify(planningService).reserveQuay(vesselId, reserveQuay.estimatedArrivalDate());
    }
}