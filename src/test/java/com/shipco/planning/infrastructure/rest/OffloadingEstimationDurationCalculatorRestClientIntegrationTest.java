package com.shipco.planning.infrastructure.rest;

import com.shipco.common.RestClient;
import com.shipco.offloading_optimization.application.OffloadingEstimationDurationApplication;
import com.shipco.offloading_optimization.domain.model.OffloadingEstimationDurationCalculator;
import com.shipco.offloading_optimization.infrastructure.rest.OffloadingEstimationDurationController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static com.shipco.planning.domain.model.TestData.vesselId;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class OffloadingEstimationDurationCalculatorRestClientIntegrationTest {

    private OffloadingEstimationDurationCalculatorRestClient restClient;

    @BeforeEach
    void setUp() {
        restClient = new OffloadingEstimationDurationCalculatorRestClient(new RestClient("http://dummy:8080", setupStub()));
    }

    @Test
    void it_calls_the_rest_client() {
        var duration = restClient.calculateOffloadingDuration(vesselId);
        assertNotNull(duration);
        assertTrue(duration.toHours() < 11L);
    }

    public Function<String, String> setupStub() {
        OffloadingEstimationDurationCalculator calculator = new OffloadingEstimationDurationCalculator();
        OffloadingEstimationDurationApplication application = new OffloadingEstimationDurationApplication(calculator);
        OffloadingEstimationDurationController controller = new OffloadingEstimationDurationController(application);
        return controller::estimatedOffloadingDuration;
    }


}