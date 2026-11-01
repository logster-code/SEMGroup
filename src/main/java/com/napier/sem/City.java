package com.napier.sem;

import java.util.ArrayList;
import java.sql.*;

/**
 * The type City used to store all results from queries involving the city table.
 */
public class City {
    /**
     * The city's name.
     */
    String name;
    /**
     * The city's country.
     */
    String country;
    /**
     * The city's district.
     */
    String district;
    /**
     * The city's population.
     */
    int population;

    /**
     * Instantiates a new City.
     *
     * @param name       the name
     * @param country    the country
     * @param district   the district
     * @param population the population
     */
    public City(String name, String country, String district, int population)
    {
        this.name = name;
        this.country = country;
        this.district = district;
        this.population = population;
    }


    /**
     * Gets cities by population using an SQL statement.
     *
     * @param con the connection to the database
     * @return the cities sorted by population descending
     */
    public static ArrayList<City> getCitiesByPop(Connection con)
    {
        ArrayList<City> cities = new ArrayList<City>();

        try
        {
            Statement stmt = con.createStatement();
            String popString =
                    "SELECT city.Name, country.Name AS Country, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "ORDER BY city.Population DESC";

            ResultSet rset = stmt.executeQuery(popString);

            while (rset.next())
            {
                City city = new City(
                        rset.getString("Name"),
                        rset.getString("Country"),
                        rset.getString("District"),
                        rset.getInt("Population"));
                cities.add(city);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities by population");
        }

        return cities;
    }

    /**
     * Gets N cities by population using an SQL statement.
     *
     * @param con the connection to the database
     * @param n the number of cities
     * @return the N cities sorted by population descending
     */
    public static ArrayList<City> getNCitiesByPop(Connection con, int n)
    {
        ArrayList<City> cities = new ArrayList<City>();

        try
        {
            Statement stmt = con.createStatement();
            String popString =
                    "SELECT city.Name, country.Name AS Country, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + n;

            ResultSet rset = stmt.executeQuery(popString);

            while (rset.next())
            {
                City city = new City(
                        rset.getString("Name"),
                        rset.getString("Country"),
                        rset.getString("District"),
                        rset.getInt("Population"));
                cities.add(city);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities by population");
        }

        return cities;
    }

    /**
     * Gets cities in a continent by population.
     *
     * @param con the connection
     * @param cont the continent
     * @return cities in a continent sorted by population descending
     */
    public static ArrayList<City> getCitiesByPopContinent(Connection con, String cont)
    {
        ArrayList<City> cities = new ArrayList<City>();

        try
        {
            Statement stmt = con.createStatement();
            String popContString =
                    "SELECT city.Name, country.Name AS Country, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Continent = '" + cont + "' "
                            + "ORDER BY city.Population DESC";

            ResultSet rset = stmt.executeQuery(popContString);

            while (rset.next())
            {
                City city = new City(
                        rset.getString("Name"),
                        rset.getString("Country"),
                        rset.getString("District"),
                        rset.getInt("Population"));
                cities.add(city);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in " + cont + " by population");
        }

        return cities;
    }

    /**
     * Gets N cities in a continent by population.
     *
     * @param con the connection
     * @param cont the continent
     * @param n the number of cities
     * @return N cities in a continent sorted by population descending
     */
    public static ArrayList<City> getNCitiesByPopContinent(Connection con, String cont, int n)
    {
        ArrayList<City> cities = new ArrayList<City>();

        try
        {
            Statement stmt = con.createStatement();
            String popContString =
                    "SELECT city.Name, country.Name AS Country, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Continent = '" + cont + "' "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + n;

            ResultSet rset = stmt.executeQuery(popContString);

            while (rset.next())
            {
                City city = new City(
                        rset.getString("Name"),
                        rset.getString("Country"),
                        rset.getString("District"),
                        rset.getInt("Population"));
                cities.add(city);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in " + cont + " by population");
        }

        return cities;
    }

    /**
     * Gets cities in a region by population.
     *
     * @param con the connection
     * @param reg the region
     * @return cities in a region sorted by population descending
     */
    public static ArrayList<City> getCitiesByPopRegion(Connection con, String reg)
    {
        ArrayList<City> cities = new ArrayList<City>();

        try
        {
            Statement stmt = con.createStatement();
            String popRegString =
                    "SELECT city.Name, country.Name AS Country, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Region = '" + reg + "' "
                            + "ORDER BY city.Population DESC";

            ResultSet rset = stmt.executeQuery(popRegString);

            while (rset.next())
            {
                City city = new City(
                        rset.getString("Name"),
                        rset.getString("Country"),
                        rset.getString("District"),
                        rset.getInt("Population"));
                cities.add(city);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in " + reg + " by population");
        }

        return cities;
    }

    /**
     * Gets N cities in a region by population.
     *
     * @param con the connection
     * @param reg the region
     * @param n the number of cities
     * @return N cities in a region sorted by population descending
     */
    public static ArrayList<City> getNCitiesByPopRegion(Connection con, String reg, int n)
    {
        ArrayList<City> cities = new ArrayList<City>();

        try
        {
            Statement stmt = con.createStatement();
            String popRegString =
                    "SELECT city.Name, country.Name AS Country, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Region = '" + reg + "' "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + n;

            ResultSet rset = stmt.executeQuery(popRegString);

            while (rset.next())
            {
                City city = new City(
                        rset.getString("Name"),
                        rset.getString("Country"),
                        rset.getString("District"),
                        rset.getInt("Population"));
                cities.add(city);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in " + reg + " by population");
        }

        return cities;
    }

    /**
     * Gets cities in a country by population.
     *
     * @param con the connection
     * @param country the country
     * @return cities in a country sorted by population descending
     */
    public static ArrayList<City> getCitiesByPopCountry(Connection con, String country)
    {
        ArrayList<City> cities = new ArrayList<City>();

        try
        {
            Statement stmt = con.createStatement();
            String popCountryString =
                    "SELECT city.Name, country.Name AS Country, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Name = '" + country + "' "
                            + "ORDER BY city.Population DESC";

            ResultSet rset = stmt.executeQuery(popCountryString);

            while (rset.next())
            {
                City city = new City(
                        rset.getString("Name"),
                        rset.getString("Country"),
                        rset.getString("District"),
                        rset.getInt("Population"));
                cities.add(city);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in " + country + " by population");
        }

        return cities;
    }

    /**
     * Gets N cities in a country by population.
     *
     * @param con the connection
     * @param country the country
     * @param n the number of cities
     * @return N cities in a country sorted by population descending
     */
    public static ArrayList<City> getNCitiesByPopCountry(Connection con, String country, int n)
    {
        ArrayList<City> cities = new ArrayList<City>();

        try
        {
            Statement stmt = con.createStatement();
            String popCountryString =
                    "SELECT city.Name, country.Name AS Country, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Name = '" + country + "' "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + n;

            ResultSet rset = stmt.executeQuery(popCountryString);

            while (rset.next())
            {
                City city = new City(
                        rset.getString("Name"),
                        rset.getString("Country"),
                        rset.getString("District"),
                        rset.getInt("Population"));
                cities.add(city);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in " + country + " by population");
        }

        return cities;
    }

    /**
     * Gets cities in a district by population.
     *
     * @param con the connection
     * @param district the district
     * @return cities in a district sorted by population descending
     */
    public static ArrayList<City> getCitiesByPopDistrict(Connection con, String district)
    {
        ArrayList<City> cities = new ArrayList<City>();

        try
        {
            Statement stmt = con.createStatement();
            String popDistrictString =
                    "SELECT city.Name, country.Name AS Country, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE city.District = '" + district + "' "
                            + "ORDER BY city.Population DESC";

            ResultSet rset = stmt.executeQuery(popDistrictString);

            while (rset.next())
            {
                City city = new City(
                        rset.getString("Name"),
                        rset.getString("Country"),
                        rset.getString("District"),
                        rset.getInt("Population"));
                cities.add(city);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in " + district + " by population");
        }

        return cities;
    }

    /**
     * Gets N cities in a district by population.
     *
     * @param con the connection
     * @param district the district
     * @param n the number of cities
     * @return N cities in a district sorted by population descending
     */
    public static ArrayList<City> getNCitiesByPopDistrict(Connection con, String district, int n)
    {
        ArrayList<City> cities = new ArrayList<City>();

        try
        {
            Statement stmt = con.createStatement();
            String popDistrictString =
                    "SELECT city.Name, country.Name AS Country, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE city.District = '" + district + "' "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + n;

            ResultSet rset = stmt.executeQuery(popDistrictString);

            while (rset.next())
            {
                City city = new City(
                        rset.getString("Name"),
                        rset.getString("Country"),
                        rset.getString("District"),
                        rset.getInt("Population"));
                cities.add(city);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in " + district + " by population");
        }

        return cities;
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
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets district.
     *
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Sets district.
     *
     * @param district the district
     */
    public void setDistrict(String district) {
        this.district = district;
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

    @Override
    public String toString() {
        return "city{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
}
