package com.shipco.offloading_optimization.infrastructure.rest;

import com.shipco.common.Accept;
import com.shipco.common.HttpMethod;
import com.shipco.common.Path;
import com.shipco.common.PathParameter;
import com.shipco.offloading_optimization.application.EstimateOffloadingDuration;
import com.shipco.offloading_optimization.application.OffloadingEstimationDurationApplication;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class OffloadingEstimationDurationController {

    private final OffloadingEstimationDurationApplication offloadingEstimationDurationApplication;

    public OffloadingEstimationDurationController(OffloadingEstimationDurationApplication offloadingEstimationDurationApplication) {
        this.offloadingEstimationDurationApplication = offloadingEstimationDurationApplication;
    }

    @Accept(methods = {HttpMethod.GET})
    @Path("/estimate")
    public String estimatedOffloadingDuration(@PathParameter("vesselId") String vesselId) {
        var command = new EstimateOffloadingDuration(UUID.fromString(vesselId));
        var duration = offloadingEstimationDurationApplication.estimateOffloadingTime(command);
        return durationAsJson(duration);
    }

    private String durationAsJson(Duration duration) {
        return """
                {"time": %d, "unit": "%s"}""".formatted(duration.toHours(), ChronoUnit.HOURS.toString());
    }
}
