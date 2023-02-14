package com.shipco.planning.infrastructure.rest;

import com.shipco.common.RestClient;
import com.shipco.planning.domain.model.OffloadingDurationCalculator;

import java.time.Duration;
import java.util.UUID;
import java.util.regex.Pattern;

public class OffloadingEstimationDurationCalculatorRestClient implements OffloadingDurationCalculator {
    @Override
    public Duration calculateOffloadingDuration(UUID vesselId) {

    }

    private Duration durationFromJson(String duration) {
        // {"time": 9, "unit": "Hours"}
        var pattern = Pattern.compile("\\{\"time\": (\\d), \"unit\": \"Hours\"\\}");
        var matcher = pattern.matcher(duration);
        matcher.find();
        var hours = Integer.parseInt(matcher.group(1));
        return Duration.ofHours(hours);
    }
}
