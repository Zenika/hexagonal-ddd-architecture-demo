package com.shipco.offloading_optimization.application;

import com.shipco.offloading_optimization.domain.model.OffloadingEstimationDurationCalculator;

import java.time.Duration;

public class OffloadingEstimationDurationApplication {

    private final OffloadingEstimationDurationCalculator offloadingEstimationDurationCalculator;

    public OffloadingEstimationDurationApplication(OffloadingEstimationDurationCalculator offloadingEstimationDurationCalculator) {
        this.offloadingEstimationDurationCalculator = offloadingEstimationDurationCalculator;
    }

    public Duration estimateOffloadingTime(EstimateOffloadingDuration command) {
        return offloadingEstimationDurationCalculator.estimateOffloadingTime();
    }

}
