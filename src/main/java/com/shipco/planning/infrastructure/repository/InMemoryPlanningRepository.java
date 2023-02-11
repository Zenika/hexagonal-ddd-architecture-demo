package com.shipco.planning.infrastructure.repository;

import com.shipco.planning.domain.model.Planning;
import com.shipco.planning.domain.model.PlanningRepository;

import java.time.Month;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class InMemoryPlanningRepository implements PlanningRepository {

    private record PlanningMonth(Year year, Month month) {}

    private final Map<PlanningMonth, Planning> monthlyPlanning = new HashMap<>();

    @Override
    public Planning findMonthlyPlanning(Year year, Month month) {
        var planningMonth = new PlanningMonth(year, month);
        return monthlyPlanning.get(planningMonth);
    }

    @Override
    public void savePlanningUpdates(Planning planning) {
        var planningMonth = new PlanningMonth(planning.getYear(), planning.getMonth());
        monthlyPlanning.put(planningMonth, planning);
    }
}
