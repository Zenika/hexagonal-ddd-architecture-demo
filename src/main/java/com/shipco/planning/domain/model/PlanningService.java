package com.shipco.planning.domain.model;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.Optional;
import java.util.UUID;

public class PlanningService {

    private final PlanningRepository planningRepository;
    private final OffloadingDurationCalculator offloadingDurationCalculator;

    public PlanningService(PlanningRepository planningRepository,
                           OffloadingDurationCalculator offloadingDurationCalculator) {
        this.planningRepository = planningRepository;
        this.offloadingDurationCalculator = offloadingDurationCalculator;
    }

    /**
     * Given a vesselId and an estimatedArrivalDate for the vessel, reserve a quay for the vessel if one is available.
     * Uses the offloadingTimeCalculator to determine the estimated duration of the offloading.
     * Checks the planning to see if a quay is available for this vessel.
     * If a quay is available, add a new reservation to the planning and returns it.
     * Otherwise, returns an empty reservation.
     */
    public Optional<Reservation> reserveQuay(UUID vesselId, LocalDateTime estimatedArrivalDate) {

    }

}
