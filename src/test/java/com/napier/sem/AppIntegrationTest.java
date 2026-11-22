package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type App integration test.
 */
public class AppIntegrationTest
{
    /**
     * Test class containing all tests for integration
     */
    static Main app;

    /**
     * Init.
     */
    @BeforeAll
    static void init()
    {
        app = new Main();
        app.connect("localhost:33060", 3000);

        assertNotNull(app.getConnection(), "Failed to connect to the database");
    }

    /**
     * Disconnect.
     */
    @AfterAll
    static void disconnect()
    {
        app.disconnect();
    }

    /**
     * Test all countries by pop.
     */
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

    /**
     * Test n countries by pop.
     */
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

    /**
     * Test countries by pop continent.
     */
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

    /**
     * Test n countries by pop continent.
     */
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

    /**
     * Test countries by pop region.
     */
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

    /**
     * Test n countries by pop region.
     */
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

    /**
     * Test all cities by pop.
     */
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

    /**
     * Test n cities by pop.
     */
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

    /**
     * Test cities by pop continent.
     */
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

    /**
     * Test n cities by pop continent.
     */
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

    /**
     * Test cities by pop region.
     */
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

    /**
     * Test n cities by pop region.
     */
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

    /**
     * Test cities by pop country.
     */
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

    /**
     * Test n cities by pop country.
     */
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

    /**
     * Test cities by pop district.
     */
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

    /**
     * Test n cities by pop district.
     */
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
