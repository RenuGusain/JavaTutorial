package com.renu.java.tutorial.design.pattern.singleton;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;


public class TestSingleton {
    @Test
    public void isSingletonTest()
    {
        SingletonDatabase db = SingletonDatabase.getInstance();
        SingletonDatabase db2 = SingletonDatabase.getInstance();
        assertSame(db, db2);
        assertEquals(1, SingletonDatabase.getCount());
    }

    @Test
    public void singletonTotalPopulationTest()
    {
        // testing on a live database
        SingletonRecordFinder rf = new SingletonRecordFinder();
        List<String> names = Arrays.asList("Seoul", "Mexico City");
        int tp = rf.getTotalPopulation(names);
        assertEquals(17500000+17400000, tp);
    }

    @Test
    public void dependentPopulationTest()
    {
        DummyDatabase db = new DummyDatabase();
        ConfigurableRecordFinder rf = new ConfigurableRecordFinder(db);
        assertEquals(4, rf.getTotalPopulation(
                Arrays.asList("alpha", "gamma")
        ));
    }
}
