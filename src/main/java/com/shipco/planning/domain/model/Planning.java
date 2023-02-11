package com.shipco.planning.domain.model;

import java.time.Month;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Planning of reservations for a specific year and a specific month.
 */
public class Planning {
    private final UUID id;
    private final Year year;
    private final Month month;
    private final List<Reservation> reservations;

    public Planning(UUID id, Year year, Month month) {
        this(id, year, month, new ArrayList<>());
    }

    public Planning(UUID id, Year year, Month month, List<Reservation> reservations) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.reservations = reservations;
    }

    public Optional<Reservation> reserveQuay(UUID vesselId, DateRange timeSlot) {
        var quays = PortInfrastructure.getQuaysId();
        var occupiedQuays = reservations.stream()
                .filter(reservation -> reservation.getTimeSlot().intersects(timeSlot))
                .map(Reservation::getQuayId)
                .collect(Collectors.toSet());

        var freeQuays = quays.stream().filter(quay -> !occupiedQuays.contains(quay)).toList();

        if(freeQuays.isEmpty()) {
            return Optional.empty();
        }

        var assignedQuay = freeQuays.get(0);
        var reservation = makeReservation(vesselId, assignedQuay, timeSlot);

        this.reservations.add(reservation);

        return Optional.of(reservation);
    }

    private Reservation makeReservation(UUID vesselId, UUID quayId, DateRange timeSlot) {
        return new Reservation(
                UUID.randomUUID(),
                vesselId,
                quayId,
                timeSlot
            );
    }

    public UUID getId() {
        return id;
    }

    public Year getYear() {
        return year;
    }

    public Month getMonth() {
        return month;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planning planning = (Planning) o;
        return Objects.equals(id, planning.id) && Objects.equals(year, planning.year) && month == planning.month && Objects.equals(reservations, planning.reservations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, month, reservations);
    }

    @Override
    public String toString() {
        return "Planning{" +
                "id=" + id +
                ", year=" + year +
                ", month=" + month +
                ", reservations=" + reservations +
                '}';
    }
}
