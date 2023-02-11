package com.shipco.planning.infrastructure;

import com.shipco.planning.infrastructure.repository.InMemoryPlanningRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.Year;

import static com.shipco.planning.domain.model.TestData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InMemoryPlanningRepositoryTest {

    InMemoryPlanningRepository inMemoryPlanningRepository;

    @BeforeEach
    void setUp() {
        inMemoryPlanningRepository = new InMemoryPlanningRepository();
    }

    @Test
    void it_updates_and_find_the_planning() {
        var decPlanning = december2022Planning();
        var janPlanning = january2023Planning();
        inMemoryPlanningRepository.savePlanningUpdates(decPlanning);
        inMemoryPlanningRepository.savePlanningUpdates(janPlanning);

        var foundPlanning = inMemoryPlanningRepository.findMonthlyPlanning(Year.of(2023), Month.JANUARY);

        assertThat(foundPlanning, equalTo(janPlanning));

        var missingPlanning = inMemoryPlanningRepository.findMonthlyPlanning(Year.of(2021), Month.MARCH);
        assertNull(missingPlanning);
    }


}