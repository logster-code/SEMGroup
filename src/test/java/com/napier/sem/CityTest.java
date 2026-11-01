
package com.napier.sem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CityTest
{
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

    @Test
    void testGetName()
    {
        City city = new City("London", "United Kingdom",
                "England", 8982000);

        assertEquals("London", city.getName());
    }

    @Test
    void testGetCountry()
    {
        City city = new City("London", "United Kingdom",
                "England", 8982000);

        assertEquals("United Kingdom", city.getCountry());
    }

    @Test
    void testGetDistrict()
    {
        City city = new City("London", "United Kingdom",
                "England", 8982000);

        assertEquals("England", city.getDistrict());
    }

    @Test
    void testGetPopulation()
    {
        City city = new City("London", "United Kingdom",
                "England", 8982000);

        assertEquals(8982000, city.getPopulation());
    }

    @Test
    void testSetName()
    {
        City city = new City("London", "United Kingdom",
                "England", 8982000);

        city.setName("Manchester");

        assertEquals("Manchester", city.getName());
    }

    @Test
    void testSetCountry()
    {
        City city = new City("London", "United Kingdom",
                "England", 8982000);

        city.setCountry("France");

        assertEquals("France", city.getCountry());
    }

    @Test
    void testSetDistrict()
    {
        City city = new City("London", "United Kingdom",
                "England", 8982000);

        city.setDistrict("Greater Manchester");

        assertEquals("Greater Manchester", city.getDistrict());
    }

    @Test
    void testSetPopulation()
    {
        City city = new City("London", "United Kingdom",
                "England", 8982000);

        city.setPopulation(1000000);

        assertEquals(1000000, city.getPopulation());
    }

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
