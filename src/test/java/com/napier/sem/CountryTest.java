package com.napier.sem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountryTest
{
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

    @Test
    void testGetCode()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        assertEquals("GBR", country.getCode());
    }

    @Test
    void testGetName()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        assertEquals("United Kingdom", country.getName());
    }

    @Test
    void testGetContinent()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        assertEquals("Europe", country.getContinent());
    }

    @Test
    void testGetRegion()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        assertEquals("Western Europe", country.getRegion());
    }

    @Test
    void testGetPopulation()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        assertEquals(67886011, country.getPopulation());
    }

    @Test
    void testGetCapital()
    {
        Country country = new Country(
                "GBR", "United Kingdom", "Europe",
                "Western Europe", 67886011, 456
        );

        assertEquals(456, country.getCapital());
    }

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
