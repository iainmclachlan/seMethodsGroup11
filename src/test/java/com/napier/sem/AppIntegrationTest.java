package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect();
    }

    @Test
    void testGetCity()
    {
        City ct = app.getCityPopulationByID(2806);
        assertEquals(ct.ID, 2806);
        assertEquals(ct.name, "Kingston");
        assertEquals(ct.population, 800);
    }
}