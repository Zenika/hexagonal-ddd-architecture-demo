package com.shipco.planning.application;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReserveQuay(UUID vesselId, LocalDateTime estimatedArrivalDate) {
}
