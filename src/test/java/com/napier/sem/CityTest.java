
package com.napier.sem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type City test.
 */
public class CityTest
{
    /**
     * Test class containing all tests for the city class
     */
    @Test
    void testCityConstructor()
    {
        City city = new City("London", "United Kingdom",
                "England", 8982000);

        assertEquals("London", city.getName());
        assertEquals("United Kingdom", city.getCountry());
        assertEquals("England", city.getDistrict());
        assertEquals(8982000, city.getPopulation());
    }

    /**
     * Test get name.
     */
    @Test
    void testGetName()
    {
        City city = new City("London", "United Kingdom",
                "England", 8982000);

        assertEquals("London", city.getName());
    }

    /**
     * Test get country.
     */
    @Test
    void testGetCountry()
    {
        City city = new City("London", "United Kingdom",
                "England", 8982000);

        assertEquals("United Kingdom", city.getCountry());
    }

    /**
     * Test get district.
     */
    @Test
    void testGetDistrict()
    {
        City city = new City("London", "United Kingdom",
                "England", 8982000);

        assertEquals("England", city.getDistrict());
    }

    /**
     * Test get population.
     */
    @Test
    void testGetPopulation()
    {
        City city = new City("London", "United Kingdom",
                "England", 8982000);

        assertEquals(8982000, city.getPopulation());
    }

    /**
     * Test set name.
     */
    @Test
    void testSetName()
    {
        City city = new City("London", "United Kingdom",
                "England", 8982000);

        city.setName("Manchester");

        assertEquals("Manchester", city.getName());
    }

    /**
     * Test set country.
     */
    @Test
    void testSetCountry()
    {
        City city = new City("London", "United Kingdom",
                "England", 8982000);

        city.setCountry("France");

        assertEquals("France", city.getCountry());
    }

    /**
     * Test set district.
     */
    @Test
    void testSetDistrict()
    {
        City city = new City("London", "United Kingdom",
                "England", 8982000);

        city.setDistrict("Greater Manchester");

        assertEquals("Greater Manchester", city.getDistrict());
    }

    /**
     * Test set population.
     */
    @Test
    void testSetPopulation()
    {
        City city = new City("London", "United Kingdom",
                "England", 8982000);

        city.setPopulation(1000000);

        assertEquals(1000000, city.getPopulation());
    }

    /**
     * Test to string.
     */
    @Test
    void testToString()
    {
        City city = new City("London", "United Kingdom",
                "England", 8982000);

        String expected = "city{name='London', country='United Kingdom', " +
                "district='England', population=8982000}";

        assertEquals(expected, city.toString());
    }
}
