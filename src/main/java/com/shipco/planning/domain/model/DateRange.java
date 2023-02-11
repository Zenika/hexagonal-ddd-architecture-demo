package com.shipco.planning.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class DateRange {
    private final LocalDateTime start;
    private final LocalDateTime end;


    public static DateRange of(LocalDateTime start, LocalDateTime end) {
        return new DateRange(start, end);
    }

    private DateRange(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateRange dateRange = (DateRange) o;
        return Objects.equals(start, dateRange.start) && Objects.equals(end, dateRange.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "DateRange{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    private boolean isInRange(LocalDateTime date) {
        return (date.isEqual(start) || date.isAfter(start))
            && (date.isEqual(end) || date.isBefore(end));
    }

    /**
     * Returns true if the given range intersects with this range.
     * For example, a DateRange(2023-01-13, 2023-01-15) intersects with a DateRange(2023-01-14, 2023-01-16).
     * But a DateRange(2023-01-13, 2023-01-14) doesn't intersect with a DateRange(2023-01-15, 2023-01-16).
     */
    public boolean intersects(DateRange range) {
        return isInRange(range.start) || isInRange(range.end);
    }
}
