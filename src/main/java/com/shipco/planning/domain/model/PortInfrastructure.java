package com.shipco.planning.domain.model;

import java.util.List;
import java.util.UUID;

public class PortInfrastructure {
    public static final Quay quay1 = new Quay(UUID.randomUUID(), 1);
    public static final Quay quay2 = new Quay(UUID.randomUUID(), 2);
    public static final Quay quay3 = new Quay(UUID.randomUUID(), 3);
    public static final Quay quay4 = new Quay(UUID.randomUUID(), 4);
    public static final Quay quay5 = new Quay(UUID.randomUUID(), 5);

    public static List<Quay> getQuays() {
        return List.of(
                quay1,
                quay2,
                quay3,
                quay4,
                quay5
        );
    }

    public static List<UUID> getQuaysId() {
        return getQuays().stream()
                .map(Quay::getId)
                .toList();
    }
}
