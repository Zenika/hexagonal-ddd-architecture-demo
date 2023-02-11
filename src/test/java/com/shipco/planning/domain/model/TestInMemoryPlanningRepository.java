package com.shipco.planning.domain.model;

import java.time.Month;
import java.time.Year;

public class TestInMemoryPlanningRepository implements PlanningRepository {

    private Planning planning;

    public TestInMemoryPlanningRepository(Planning initialPlanning) {
        this.planning = initialPlanning;
    }

    @Override
    public Planning findMonthlyPlanning(Year year, Month month) {
        return planning;
    }

    @Override
    public void savePlanningUpdates(Planning planning) {
        this.planning = planning;
    }

    public Planning getSavedPlanning() {
        return planning;
    }

    public void resetPlanning(Planning planning) {
        this.planning = planning;
    }
}
