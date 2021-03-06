package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class mytest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void getCityPopulationTestNull()
    {
        if(app.getCityPopulationDESC() != null)
        {
            System.out.println("Value is not NULL");
        }
        else
        {
            System.out.println("Value is NULL");
        }
    }

    @Test
    void unitTest3()
    {
        assertEquals(5, 5, "Messages are equal");
    }

    @Test
    void getWorldPopulationTestNull()
    {
        if(app.getWorldPopulation() != null)
        {
            System.out.println("Value is not NULL");
        }
        else
        {
            System.out.println("Value is NULL");
        }
    }

}
