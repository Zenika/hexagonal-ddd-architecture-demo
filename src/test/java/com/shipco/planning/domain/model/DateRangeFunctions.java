package com.shipco.planning.domain.model;

import java.time.LocalDateTime;

public class DateRangeFunctions {
    public static DateRange range(LocalDateTime start, LocalDateTime end) {
        return DateRange.of(start, end);
    }
}
