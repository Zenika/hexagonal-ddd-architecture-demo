package com.shipco.planning.domain.model;

import java.time.Duration;
import java.util.UUID;

/**
 * Calculate the duration of an offloading of a specific vesselId.
 * Gateway interface to an external API.
 */
public interface OffloadingDurationCalculator {

    Duration calculateOffloadingDuration(UUID vesselId);

}
