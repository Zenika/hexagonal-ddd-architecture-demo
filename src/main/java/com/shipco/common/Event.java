package com.shipco.common;

import java.time.LocalDateTime;
import java.util.UUID;

public interface Event {

    UUID eventId();

    LocalDateTime occurredAt();

    String aggregate();

    UUID aggregateId();
}
