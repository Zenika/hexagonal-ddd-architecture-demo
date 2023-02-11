package com.shipco.planning.application;

import com.shipco.planning.domain.model.PlanningService;
import com.shipco.planning.domain.model.Reservation;

import java.util.Optional;

public class PlanningApplication {

    private final PlanningService planningService;

    public PlanningApplication(PlanningService planningService) {
        this.planningService = planningService;
    }

    public Optional<Reservation> reserveQuay(ReserveQuay reserveQuay) {
        return planningService.reserveQuay(
                reserveQuay.vesselId(),
                reserveQuay.estimatedArrivalDate()
            );
    }
}
