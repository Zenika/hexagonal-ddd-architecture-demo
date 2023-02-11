package com.shipco.planning.domain.model;

import java.util.Objects;
import java.util.UUID;

public class Reservation {
    private final UUID id;
    private final UUID vesselId;
    private final UUID quayId;
    private final DateRange timeSlot;

    public Reservation(UUID id, UUID vesselId, UUID quayId, DateRange timeSlot) {
        this.id = id;
        this.vesselId = vesselId;
        this.quayId = quayId;
        this.timeSlot = timeSlot;
    }

    public UUID getId() {
        return id;
    }

    public UUID getVesselId() {
        return vesselId;
    }

    public UUID getQuayId() {
        return quayId;
    }

    public DateRange getTimeSlot() {
        return timeSlot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id) && Objects.equals(vesselId, that.vesselId) && Objects.equals(quayId, that.quayId) && Objects.equals(timeSlot, that.timeSlot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vesselId, quayId, timeSlot);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", vesselId=" + vesselId +
                ", quayId=" + quayId +
                ", timeSlot=" + timeSlot +
                '}';
    }
}
