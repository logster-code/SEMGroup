package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static Main app;

    @BeforeAll
    static void init()
    {
        app = new Main();
        app.connect("localhost:33060", 30000);

        assertNotNull(app.getConnection(), "Failed to connect to the database");
    }

    @AfterAll
    static void disconnect()
    {
        app.disconnect();
    }

    @Test
    void testAllCountriesByPop()
    {
        ArrayList<Country> countries =
                Country.getCountriesByPop(app.getConnection());

        assertNotNull(countries);
        assertEquals(239, countries.size());

        for (int i = 0; i < countries.size() - 1; i++)
        {
            assertTrue(countries.get(i).getPopulation() >=
                    countries.get(i + 1).getPopulation());
        }
    }

    @Test
    void testNCountriesByPop()
    {
        ArrayList<Country> countries =
                Country.getNCountriesByPop(app.getConnection(), 10);

        assertNotNull(countries);
        assertEquals(10, countries.size());

        for (int i = 0; i < countries.size() - 1; i++)
        {
            assertTrue(countries.get(i).getPopulation() >=
                    countries.get(i + 1).getPopulation());
        }
    }

    @Test
    void testCountriesByPopContinent()
    {
        ArrayList<Country> countries =
                Country.getCountriesByPopContinent(
                        app.getConnection(), "Europe");

        assertNotNull(countries);
        assertFalse(countries.isEmpty());

        for (Country country : countries)
        {
            assertEquals("Europe", country.getContinent());
        }

        for (int i = 0; i < countries.size() - 1; i++)
        {
            assertTrue(countries.get(i).getPopulation() >=
                    countries.get(i + 1).getPopulation());
        }
    }

    @Test
    void testNCountriesByPopContinent()
    {
        ArrayList<Country> countries =
                Country.getNCountriesByPopContinent(
                        app.getConnection(), "Europe", 5);

        assertNotNull(countries);
        assertEquals(5, countries.size());

        for (Country country : countries)
        {
            assertEquals("Europe", country.getContinent());
        }
    }

    @Test
    void testCountriesByPopRegion()
    {
        ArrayList<Country> countries =
                Country.getCountriesByPopRegion(
                        app.getConnection(), "Western Europe");

        assertNotNull(countries);
        assertFalse(countries.isEmpty());

        for (Country country : countries)
        {
            assertEquals("Western Europe", country.getRegion());
        }

        for (int i = 0; i < countries.size() - 1; i++)
        {
            assertTrue(countries.get(i).getPopulation() >=
                    countries.get(i + 1).getPopulation());
        }
    }

    @Test
    void testNCountriesByPopRegion()
    {
        ArrayList<Country> countries =
                Country.getNCountriesByPopRegion(
                        app.getConnection(), "Western Europe", 5);

        assertNotNull(countries);
        assertEquals(5, countries.size());

        for (Country country : countries)
        {
            assertEquals("Western Europe", country.getRegion());
        }
    }
}