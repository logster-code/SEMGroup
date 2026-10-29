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
            "yes", "10", "no", "yes", "Europe", "no", "no", "yes", "Western Europe", "yes", "5", "no"
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
        m.connect();

        // call each feature method
        allCountriesByPop(m);
        countriesContinentByPop(m);
        countriesRegionByPop(m);

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
     * connects to the database and alerts user of any problems
     */
    public void connect()
    {
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
                Thread.sleep(30000);
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
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
}