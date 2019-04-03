package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void testGetCity()
    {
        City ct = app.getCityPopulationByID(2806);
        assertEquals(ct.ID, 2806);
        assertEquals(ct.name, "Kingston");
        assertEquals(ct.population, 800);
    }


    @Test
    void testGetCountryByCode()
    {
        String countryCode = "AIA";
        Country ctr = app.getCountryPopulationByCode(countryCode);
        assertEquals(ctr.country_code,"AIA");
        assertEquals(ctr.country_name,"Anguilla");
        assertEquals(ctr.country_population,8000);
    }

}
