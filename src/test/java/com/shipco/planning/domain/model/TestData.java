package com.shipco.planning.domain.model;

import com.shipco.planning.application.ReserveQuay;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.shipco.planning.domain.model.DateRangeFunctions.range;
import static com.shipco.planning.domain.model.PortInfrastructure.*;

public class TestData {
    private static final LocalDateTime january3rd_14_00 = LocalDateTime.of(2023, Month.JANUARY, 3, 14, 0);
    private static final LocalDateTime january3rd_15_00 = january3rd_14_00.plusHours(1);
    private static final LocalDateTime january3rd_16_00 = january3rd_14_00.plusHours(2);
    private static final LocalDateTime january3rd_17_00 = january3rd_14_00.plusHours(3);
    private static final LocalDateTime january4th_14_00 = january3rd_14_00.plusDays(1);
    private static final LocalDateTime january4th_15_00 = january4th_14_00.plusHours(1);
    private static final LocalDateTime january4th_16_00 = january4th_14_00.plusHours(2);
    public static final UUID vesselId = UUID.randomUUID();
    public static final UUID otherVesselId = UUID.randomUUID();
    public static final UUID anotherVesselId = UUID.randomUUID();
    public static final UUID anotherVessel2Id = UUID.randomUUID();
    public static final LocalDateTime vesselEstimatedArrivalDate = january3rd_14_00;

    public static Planning planningWithNoReservation() {
        return new Planning(UUID.randomUUID(), Year.of(january3rd_14_00.getYear()), january3rd_14_00.getMonth());
    }

    public static Planning planningWithSomeReservations() {
        var priorReservations = List.of(
                new Reservation(UUID.randomUUID(), otherVesselId, quay1.getId(),
                        range(january3rd_14_00, january3rd_16_00)
                ),
                new Reservation(UUID.randomUUID(), anotherVesselId, quay2.getId(),
                        range(january3rd_14_00, january3rd_16_00)
                ),
                new Reservation(UUID.randomUUID(), anotherVesselId, quay3.getId(),
                        range(january3rd_14_00, january3rd_16_00)
                ),
                new Reservation(UUID.randomUUID(), anotherVesselId, quay4.getId(),
                        range(january4th_14_00, january4th_15_00)
                ),
                new Reservation(UUID.randomUUID(), anotherVesselId, quay5.getId(),
                        range(january4th_14_00, january4th_16_00)
                )
        );

        return new Planning(UUID.randomUUID(), Year.of(january3rd_14_00.getYear()), january3rd_14_00.getMonth(), new ArrayList<>(priorReservations));
    }

    public static Planning december2022Planning() {
        return new Planning(UUID.randomUUID(), Year.of(2022), Month.DECEMBER);
    }

    public static Planning january2023Planning() {
        return new Planning(UUID.randomUUID(), Year.of(2023), Month.JANUARY);
    }

    public static Planning planningWithFullReservations() {
        var priorReservations = List.of(
                new Reservation(UUID.randomUUID(), otherVesselId, quay1.getId(),
                        range(january3rd_14_00, january3rd_16_00)
                    ),
                new Reservation(UUID.randomUUID(), anotherVesselId, quay2.getId(),
                        range(january3rd_14_00, january3rd_16_00)
                ),
                new Reservation(UUID.randomUUID(), anotherVesselId, quay3.getId(),
                        range(january3rd_14_00, january3rd_16_00)
                ),
                new Reservation(UUID.randomUUID(), anotherVesselId, quay4.getId(),
                        range(january3rd_14_00, january3rd_16_00)
                ),
                new Reservation(UUID.randomUUID(), anotherVesselId, quay5.getId(),
                        range(january3rd_14_00, january3rd_16_00)
                )
            );

        return new Planning(UUID.randomUUID(), Year.of(january3rd_14_00.getYear()), january3rd_14_00.getMonth(), new ArrayList<>(priorReservations));
    }

    public static final ReserveQuay reserveQuay = new ReserveQuay(vesselId, january3rd_14_00);
}
