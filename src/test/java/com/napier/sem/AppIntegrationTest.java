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
        app.connect("localhost:33060", 3000);

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

    @Test
    void testAllCitiesByPop()
    {
        ArrayList<City> cities =
                City.getCitiesByPop(app.getConnection());

        assertNotNull(cities);
        assertEquals(4079, cities.size());

        for (int i = 0; i < cities.size() - 1; i++)
        {
            assertTrue(cities.get(i).getPopulation() >=
                    cities.get(i + 1).getPopulation());
        }
    }

    @Test
    void testNCitiesByPop()
    {
        ArrayList<City> cities =
                City.getNCitiesByPop(app.getConnection(), 10);

        assertNotNull(cities);
        assertEquals(10, cities.size());

        for (int i = 0; i < cities.size() - 1; i++)
        {
            assertTrue(cities.get(i).getPopulation() >=
                    cities.get(i + 1).getPopulation());
        }
    }

    @Test
    void testCitiesByPopContinent()
    {
        ArrayList<City> cities =
                City.getCitiesByPopContinent(
                        app.getConnection(), "Europe");

        assertNotNull(cities);
        assertFalse(cities.isEmpty());

        for (City city : cities)
        {
            assertTrue(city.getPopulation() >= 0);
        }

        for (int i = 0; i < cities.size() - 1; i++)
        {
            assertTrue(cities.get(i).getPopulation() >=
                    cities.get(i + 1).getPopulation());
        }
    }

    @Test
    void testNCitiesByPopContinent()
    {
        ArrayList<City> cities =
                City.getNCitiesByPopContinent(
                        app.getConnection(), "Europe", 5);

        assertNotNull(cities);
        assertEquals(5, cities.size());

        for (int i = 0; i < cities.size() - 1; i++)
        {
            assertTrue(cities.get(i).getPopulation() >=
                    cities.get(i + 1).getPopulation());
        }
    }

    @Test
    void testCitiesByPopRegion()
    {
        ArrayList<City> cities =
                City.getCitiesByPopRegion(
                        app.getConnection(), "Western Europe");

        assertNotNull(cities);
        assertFalse(cities.isEmpty());

        for (int i = 0; i < cities.size() - 1; i++)
        {
            assertTrue(cities.get(i).getPopulation() >=
                    cities.get(i + 1).getPopulation());
        }
    }

    @Test
    void testNCitiesByPopRegion()
    {
        ArrayList<City> cities =
                City.getNCitiesByPopRegion(
                        app.getConnection(), "Western Europe", 5);

        assertNotNull(cities);
        assertEquals(5, cities.size());

        for (int i = 0; i < cities.size() - 1; i++)
        {
            assertTrue(cities.get(i).getPopulation() >=
                    cities.get(i + 1).getPopulation());
        }
    }

    @Test
    void testCitiesByPopCountry()
    {
        ArrayList<City> cities =
                City.getCitiesByPopCountry(
                        app.getConnection(), "United Kingdom");

        assertNotNull(cities);
        assertFalse(cities.isEmpty());

        for (City city : cities)
        {
            assertEquals("United Kingdom", city.getCountry());
        }

        for (int i = 0; i < cities.size() - 1; i++)
        {
            assertTrue(cities.get(i).getPopulation() >=
                    cities.get(i + 1).getPopulation());
        }
    }

    @Test
    void testNCitiesByPopCountry()
    {
        ArrayList<City> cities =
                City.getNCitiesByPopCountry(
                        app.getConnection(), "United Kingdom", 5);

        assertNotNull(cities);
        assertEquals(5, cities.size());

        for (City city : cities)
        {
            assertEquals("United Kingdom", city.getCountry());
        }
    }

    @Test
    void testCitiesByPopDistrict()
    {
        ArrayList<City> cities =
                City.getCitiesByPopDistrict(
                        app.getConnection(), "England");

        assertNotNull(cities);
        assertFalse(cities.isEmpty());

        for (City city : cities)
        {
            assertEquals("England", city.getDistrict());
        }

        for (int i = 0; i < cities.size() - 1; i++)
        {
            assertTrue(cities.get(i).getPopulation() >=
                    cities.get(i + 1).getPopulation());
        }
    }

    @Test
    void testNCitiesByPopDistrict()
    {
        ArrayList<City> cities =
                City.getNCitiesByPopDistrict(
                        app.getConnection(), "England", 5);

        assertNotNull(cities);
        assertEquals(5, cities.size());

        for (City city : cities)
        {
            assertEquals("England", city.getDistrict());
        }
    }
}
