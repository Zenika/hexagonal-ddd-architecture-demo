package com.shipco.planning.domain.model;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static com.shipco.planning.domain.model.DateRangeFunctions.range;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DateRangeTest {

    private final LocalDateTime january3rd = LocalDateTime.of(2023, Month.JANUARY, 3, 14, 00);
    private final LocalDateTime january4th = january3rd.plusDays(1);
    private final LocalDateTime january5th = january3rd.plusDays(2);
    private final LocalDateTime january6th = january3rd.plusDays(3);

    @Test
    void it_intersects_with_another_date_range() {
        assertTrue(range(january3rd, january5th).intersects(range(january4th, january6th)));
        assertFalse(range(january3rd, january4th).intersects(range(january5th, january6th)));
    }
}