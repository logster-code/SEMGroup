package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * main class for our program. will be used to call all the data we have sorted and display the results.
 */
public class Main
{
    // variable used to create the database connection
    private Connection con = null;

    /**
     * The constant regionsMessage. Prompt to show all regions for a user to choose from
     */
    public static final String regionsMessage = "please enter one of the following regions: \n Australia and New Zealand " +
            "\n Baltic Countries \n British Islands \n Caribbean " +
            "\n Central Africa \n Central America " +
            "\n eastern Africa \n Eastern Asia \n Eastern Europe \n Melanesia " +
            "\n Micronesia \n Micronesia/Caribbean \n Middle East \n Nordic Countries " +
            "\n North America \n Northern Africa \n Polynesia \n South America \n Southeast Asia " +
            "\n Southern Africa \n Southern Europe \n Southern and Central Asia \n Western Africa " +
            "\n Western Europe \n this is case sensitive! ";

    /**
     * The constant continentMessage. Prompt to show all continents for a user to choose from
     */
    public static final String continentMessage = "please enter one of the following continents: \n Africa \n Antarctica " +
            "\n Asia \n Europe \n Oceania \n North America \n South America \n this is case sensitive!\n";

    public static final String[] inputs = new String[]{
            "yes", "10", "no", "yes", "Europe", "no", "no", "yes",
            "Western Europe", "yes", "5", "no","yes", "10",
            "yes", "Europe", "no", "yes", "Western Europe", "no",
            "yes", "United Kingdom", "no", "yes", "England", "no"
    };

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        // create new main and begin connection process to database
        Main m = new Main();
        if(args.length < 1){
            m.connect("localhost:33060", 30000);
        }else{
            m.connect(args[0], Integer.parseInt(args[1]));
        }

        // call each feature method
        allCountriesByPop(m);
        countriesContinentByPop(m);
        countriesRegionByPop(m);
        allCitiesByPop(m);
        citiesContinentByPop(m);
        citiesRegionByPop(m);
        citiesCountryByPop(m);
        citiesDistrictByPop(m);

        m.disconnect();
    }

    /**
     * Feature 1. display every country in the world
     * ordered by population descending
     * Feature 4. adds a limit option to feature 1
     *
     * @param m the object m to create a database connection
     */
    public static void allCountriesByPop(Main m)
    {
        // check if user wants a limit on the output.
        System.out.println("do you want a limit on the number of countries ordered by population to see? ");
        System.out.println(inputs[0]);

        if  (inputs[0].equals("no"))
        {
            //create array list to store countries and print each country out
            ArrayList<Country> countriesByPop = new ArrayList<>(Country.getCountriesByPop(m.con));
            System.out.println("countries in the world filtered by population:");
            for (Country c : countriesByPop)
            {
                System.out.println(c.toString());
            }
        }
        // if so receive the limit and pass it to the appropriate method.
        while (!inputs[0].equals("no"))
        {
            System.out.println("please enter a positive integer value for the limit.");
            System.out.println(inputs[1]);
            // create array list to store countries and print each country out
            ArrayList<Country> countriesByPop = new ArrayList<>(Country.getNCountriesByPop(m.con, Integer.parseInt(inputs[1])));
            for (Country c : countriesByPop)
            {
                System.out.println(c.toString());
            }
            System.out.println("would you like to redo this with a different number? (if you would like to see all countries please enter yes then 239)");
            System.out.println(inputs[2]);
            if (inputs[2].equals("no"))
            {
                break;
            }
        }
    }

    /**
     * Feature 2. display every country in a continent
     * ordered by population descending
     *Feature 5. adds a limit option to feature 2
     *
     *
     * @param m the object m to create a database connection
     */
    public static void countriesContinentByPop(Main m)
    {
        //  receive decision on continents list
        System.out.println("Would you like to see a continents countries sorted by population? (yes/no)");
        System.out.println(inputs[3]);

        // loop while user wants to see continents list
        while (!inputs[3].equals("no")) {
            // receive continent to see
            System.out.println(continentMessage);
            System.out.println(inputs[4]);
            System.out.println("do you want a limit on the number of countries in "+ inputs[4] +" ordered by population to see? ");
            System.out.println(inputs[5]);

            if (inputs[5].equals("no"))
            {
                // create array list and assign countries in chosen continent using Country method
                ArrayList<Country> countriesByPopContinent = new ArrayList<>(Country.getCountriesByPopContinent(m.con, inputs[4]));
                System.out.println("countries in " + inputs[4] + " filtered by population:");
                for (Country c : countriesByPopContinent) {
                    System.out.println(c.toString());
                }
                // ask user if they'd like to continue
                System.out.println("would you like to see another continent?");
                System.out.println(inputs[6]);
                if (inputs[6].equals("no"))
                {
                    break;
                }
            }
            else
            {
                // receive value for limit
                System.out.println("please enter a positive integer value for the limit.");
                int limit = 0;
                // create array list and assign countries in chosen continent using Country method
                ArrayList<Country> countriesByPopContinent = new ArrayList<>(Country.getNCountriesByPopContinent(m.con, inputs[4], limit));
                System.out.println("first "+ limit +" countries in " + inputs[4] + " filtered by population:");
                // print each country
                for (Country c : countriesByPopContinent) {
                    System.out.println(c.toString());
                }
                // ask user if they'd like to continue
                System.out.println("would you like to see another continent?");
                String userChoice = "no";
                if (userChoice.equals("no"))
                {
                    break;
                }
            }

        }
    }

    /**
     * Feature 3. display every country in a region
     * ordered by population descending
     * Feature 6. adds a limit option to feature 3
     * @param m the object m to create a database connection
     */
    public static void countriesRegionByPop(Main m)
    {
        // process will be same as continent simply replacing the continents with regions.
        System.out.println("Would you like to see a regions countries sorted by population? (yes/no)");
        System.out.println(inputs[7]);

        // loop while user wants to see region list
        while (!inputs[7].equals("no")) {
            // receive region to see
            System.out.println(regionsMessage);
            System.out.println(inputs[8]);
            System.out.println("do you want a limit on the number of countries in "+ inputs[8] +" ordered by population to see? ");
            System.out.println(inputs[9]);

            if (inputs[9].equals("no"))
            {
                // create array list and assign countries in chosen region using Country method
                ArrayList<Country> countriesByPopRegion = new ArrayList<>(Country.getCountriesByPopRegion(m.con, inputs[8]));
                System.out.println("countries in " + inputs[8] + " filtered by population:");
                for (Country c : countriesByPopRegion) {
                    System.out.println(c.toString());
                }
                // ask user if they'd like to continue
                System.out.println("would you like to see another region?");
                System.out.println(inputs[11]);
                if (inputs[11].equals("no"))
                {
                    break;
                }
            }
            else
            {
                System.out.println("please enter a positive integer value for the limit.");
                System.out.println(inputs[10]);
                // create array list and assign countries in chosen region using Country method
                ArrayList<Country> countriesByPopRegion = new ArrayList<>(Country.getNCountriesByPopRegion(m.con, inputs[8], Integer.parseInt(inputs[10])));
                System.out.println("the first "+ inputs[10] +" countries in " + inputs[8] + " filtered by population:");
                for (Country c : countriesByPopRegion) {
                    System.out.println(c.toString());
                }
                // ask user if they'd like to continue
                System.out.println("would you like to see another region?");
                System.out.println(inputs[11]);
                if (inputs[11].equals("no"))
                {
                    break;
                }
            }
        }
    }

    /**
     * Feature 7. Display every city in the world.
     * Feature 8. Adds a limit option.
     *
     * @param m the object m to create a database connection
     */
    public static void allCitiesByPop(Main m)
    {
        System.out.println("Do you want a limit on the number of cities ordered by population to see?");
        System.out.println(inputs[12]);

        if (inputs[12].equals("no"))
        {
            ArrayList<City> citiesByPop = new ArrayList<>(City.getCitiesByPop(m.con));
            System.out.println("cities in the world filtered by population:");

            for (City c : citiesByPop)
            {
                System.out.println(c.toString());
            }
        }
        else
        {
            System.out.println("Please enter a positive integer value for the limit.");
            System.out.println(inputs[13]);

            ArrayList<City> citiesByPop = new ArrayList<>(
                    City.getNCitiesByPop(m.con, Integer.parseInt(inputs[13])));

            for (City c : citiesByPop)
            {
                System.out.println(c.toString());
            }
        }
    }

    /**
     * Feature 9. Display cities in a continent by population.
     * Feature 10. Adds a limit option.
     *
     * @param m the object m to create a database connection
     */
    public static void citiesContinentByPop(Main m)
    {
        System.out.println("Would you like to see a continent's cities sorted by population? (yes/no)");
        System.out.println(inputs[14]);

        while (!inputs[14].equals("no"))
        {
            System.out.println(continentMessage);
            System.out.println(inputs[15]);

            System.out.println("Do you want a limit on the number of cities in "
                    + inputs[15] + " ordered by population to see?");
            System.out.println(inputs[16]);

            if (inputs[16].equals("no"))
            {
                ArrayList<City> citiesByPopContinent = new ArrayList<>(
                        City.getCitiesByPopContinent(m.con, inputs[15]));

                System.out.println("cities in " + inputs[15] + " filtered by population:");

                for (City c : citiesByPopContinent)
                {
                    System.out.println(c.toString());
                }

                System.out.println("Would you like to see another continent?");
                System.out.println("no");

                break;
            }
            else
            {
                System.out.println("Please enter a positive integer value for the limit.");
                System.out.println("5");

                ArrayList<City> citiesByPopContinent = new ArrayList<>(
                        City.getNCitiesByPopContinent(m.con, inputs[15], 5));

                for (City c : citiesByPopContinent)
                {
                    System.out.println(c.toString());
                }

                break;
            }
        }
    }

    /**
     * Feature 11. Display cities in a region by population.
     * Feature 12. Adds a limit option.
     *
     * @param m the object m to create a database connection
     */
    public static void citiesRegionByPop(Main m)
    {
        System.out.println("Would you like to see a region's cities sorted by population? (yes/no)");
        System.out.println(inputs[17]);

        while (!inputs[17].equals("no"))
        {
            System.out.println(regionsMessage);
            System.out.println(inputs[18]);

            System.out.println("Do you want a limit on the number of cities in "
                    + inputs[18] + " ordered by population to see?");
            System.out.println(inputs[19]);

            if (inputs[19].equals("no"))
            {
                ArrayList<City> citiesByPopRegion = new ArrayList<>(
                        City.getCitiesByPopRegion(m.con, inputs[18]));

                System.out.println("cities in " + inputs[18] + " filtered by population:");

                for (City c : citiesByPopRegion)
                {
                    System.out.println(c.toString());
                }

                break;
            }
            else
            {
                ArrayList<City> citiesByPopRegion = new ArrayList<>(
                        City.getNCitiesByPopRegion(m.con, inputs[18], 5));

                for (City c : citiesByPopRegion)
                {
                    System.out.println(c.toString());
                }

                break;
            }
        }
    }

    /**
     * Feature 13. Display cities in a country by population.
     * Feature 14. Adds a limit option.
     *
     * @param m the object m to create a database connection
     */
    public static void citiesCountryByPop(Main m)
    {
        System.out.println("Would you like to see a country's cities sorted by population? (yes/no)");
        System.out.println(inputs[20]);

        while (!inputs[20].equals("no"))
        {
            System.out.println("Please enter a country:");
            System.out.println(inputs[21]);

            System.out.println("Do you want a limit on the number of cities?");
            System.out.println(inputs[22]);

            if (inputs[22].equals("no"))
            {
                ArrayList<City> citiesByPopCountry = new ArrayList<>(
                        City.getCitiesByPopCountry(m.con, inputs[21]));

                for (City c : citiesByPopCountry)
                {
                    System.out.println(c.toString());
                }

                break;
            }
            else
            {
                ArrayList<City> citiesByPopCountry = new ArrayList<>(
                        City.getNCitiesByPopCountry(m.con, inputs[21], 5));

                for (City c : citiesByPopCountry)
                {
                    System.out.println(c.toString());
                }

                break;
            }
        }
    }

    /**
     * Feature 15. Display cities in a district by population.
     * Feature 16. Adds a limit option.
     *
     * @param m the object m to create a database connection
     */
    public static void citiesDistrictByPop(Main m)
    {
        System.out.println("Would you like to see a district's cities sorted by population? (yes/no)");
        System.out.println(inputs[23]);

        while (!inputs[23].equals("no"))
        {
            System.out.println("Please enter a district:");
            System.out.println(inputs[24]);

            System.out.println("Do you want a limit on the number of cities?");
            System.out.println(inputs[25]);

            if (inputs[25].equals("no"))
            {
                ArrayList<City> citiesByPopDistrict = new ArrayList<>(
                        City.getCitiesByPopDistrict(m.con, inputs[24]));

                for (City c : citiesByPopDistrict)
                {
                    System.out.println(c.toString());
                }

                break;
            }
            else
            {
                ArrayList<City> citiesByPopDistrict = new ArrayList<>(
                        City.getNCitiesByPopDistrict(m.con, inputs[24], 5));

                for (City c : citiesByPopDistrict)
                {
                    System.out.println(c.toString());
                }

                break;
            }
        }
    }


    /**
     * connects to the database and alerts user of any problems
     */
    public void connect(String location, int delay) {

        // load database driver and deals with failure to load
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }
        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            // loads the connection to the database and deals with failed connections
            try
            {
                Thread.sleep(delay);
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * closes database connection and alerts user of any problems in closing the connection
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
    /**
     * Gets the database connection.
     *
     * @return the database connection
     */
    public Connection getConnection()
    {
        return con;
    }
}