package com.napier.sem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Country test.
 */
public class CountryTest
{
    /**
     * Test class containing all tests for the country class
     */
    @Test
    void testCountryConstructor()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        assertEquals("GBR", country.getCode());
        assertEquals("United Kingdom", country.getName());
        assertEquals("Europe", country.getContinent());
        assertEquals("Western Europe", country.getRegion());
        assertEquals(67886011, country.getPopulation());
        assertEquals(456, country.getCapital());
    }

    /**
     * Test get code.
     */
    @Test
    void testGetCode()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        assertEquals("GBR", country.getCode());
    }

    /**
     * Test get name.
     */
    @Test
    void testGetName()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        assertEquals("United Kingdom", country.getName());
    }

    /**
     * Test get continent.
     */
    @Test
    void testGetContinent()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        assertEquals("Europe", country.getContinent());
    }

    /**
     * Test get region.
     */
    @Test
    void testGetRegion()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        assertEquals("Western Europe", country.getRegion());
    }

    /**
     * Test get population.
     */
    @Test
    void testGetPopulation()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        assertEquals(67886011, country.getPopulation());
    }

    /**
     * Test get capital.
     */
    @Test
    void testGetCapital()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        assertEquals(456, country.getCapital());
    }

    /**
     * Test set code.
     */
    @Test
    void testSetCode()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        country.setCode("FRA");

        assertEquals("FRA", country.getCode());
    }

    /**
     * Test set name.
     */
    @Test
    void testSetName()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        country.setName("France");

        assertEquals("France", country.getName());
    }

    /**
     * Test set continent.
     */
    @Test
    void testSetContinent()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        country.setContinent("Asia");

        assertEquals("Asia", country.getContinent());
    }

    /**
     * Test set region.
     */
    @Test
    void testSetRegion()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        country.setRegion("Eastern Europe");

        assertEquals("Eastern Europe", country.getRegion());
    }

    /**
     * Test set population.
     */
    @Test
    void testSetPopulation()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        country.setPopulation(1000000);

        assertEquals(1000000, country.getPopulation());
    }

    /**
     * Test set capital.
     */
    @Test
    void testSetCapital()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        country.setCapital(100);

        assertEquals(100, country.getCapital());
    }

    /**
     * Test to string.
     */
    @Test
    void testToString()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        String expected = "country{code='GBR', name='United Kingdom', " +
                "continent='Europe', region='Western Europe', " +
                "population=67886011, capital=456}";

        assertEquals(expected, country.toString());
    }
}
