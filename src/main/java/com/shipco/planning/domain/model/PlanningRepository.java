package com.shipco.planning.domain.model;

import java.time.Year;
import java.time.Month;

public interface PlanningRepository {

    Planning findMonthlyPlanning(Year year, Month month);

    void savePlanningUpdates(Planning planning);
}
