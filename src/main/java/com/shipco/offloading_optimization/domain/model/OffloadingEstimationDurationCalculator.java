package com.shipco.offloading_optimization.domain.model;

import java.time.Duration;
import java.util.Random;

public class OffloadingEstimationDurationCalculator {

    private final Random random = new Random();

    public Duration estimateOffloadingTime() {
        return Duration.ofHours(random.nextInt(10));
    }

}
