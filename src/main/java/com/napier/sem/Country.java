package com.napier.sem;

import java.util.ArrayList;
import java.sql.*;

/**
 * The type Country used to store all results from queries involving the country table.
 */
public class Country {
    /**
     * The country code.
     */
    String code;
    /**
     * The country's name.
     */
    String name;
    /**
     * The country's continent.
     */
    String continent;
    /**
     * The country's region.
     */
    String region;
    /**
     * The country's population.
     */
    int population;
    /**
     * The country's capital.
     */
    int capital;

    /**
     * Instantiates a new Country.
     *
     * @param code       the code
     * @param name       the name
     * @param continent  the continent
     * @param region     the region
     * @param population the population
     * @param capital    the capital
     */
    public Country(String code, String name, String continent, String region, int population, int capital)
    {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
    }

    /**
     * Gets countries by population using an sql statement.
     *
     * @param con the connection to the database
     * @return the countries sorted by population descending
     */
    public static ArrayList<Country> getCountriesByPop(Connection con)
    {
        //creates empty list to store countries
        ArrayList<Country> countries = new ArrayList<Country>();
        // try catch to deal with sqlexception
        try
        {
            // creates the statement and result set for the query
            Statement stmt = con.createStatement();
            String popString =
                    "SELECT code, name, continent, region, population, capital "
                    + "FROM country "
                    + "ORDER BY population DESC";
            ResultSet rset = stmt.executeQuery(popString);

            // while there is more results add each country into the array list
            while (rset.next())
            {
                Country cntry = new Country(rset.getString("code"),
                        rset.getString("name"),
                        rset.getString("continent"),
                        rset.getString("region"),
                        rset.getInt("population"),
                        rset.getInt("capital"));
                countries.add(cntry);
            }
        }
        catch (Exception e)
            {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries by population");
            }
        return countries;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets continent.
     *
     * @return the continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Sets continent.
     *
     * @param continent the continent
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Gets region.
     *
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets region.
     *
     * @param region the region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Gets population.
     *
     * @return the population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Sets population.
     *
     * @param population the population
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * Gets capital.
     *
     * @return the capital
     */
    public int getCapital() {
        return capital;
    }

    /**
     * Sets capital.
     *
     * @param capital the capital
     */
    public void setCapital(int capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", population=" + population +
                ", capital=" + capital +
                '}';
    }
}
