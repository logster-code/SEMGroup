package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

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
        feature1and4(m);
        feature2and5(m);
        feature3and6(m);

        m.disconnect();
    }

    /**
     * Feature 1. display every country in the world
     * ordered by population descending
     *
     * @param m the object m to create a database connection
     */
    public static void feature1and4(Main m)
    {
        Scanner scan = new Scanner(System.in);
        // check if user wants a limit on the output.
        System.out.println("do you want a limit on the number of countries ordered by population to see? ");
        String willLimit = scan.nextLine();
        // if so receive the limit and pass it to the appropriate method.
        if (willLimit.equals("yes"))
        {
            System.out.println("please enter a positive integer value for the limit.");
            int limit = scan.nextInt();
            // create array list to store countries and print each country out
            ArrayList<Country> countriesByPop = new ArrayList<>(Country.getNCountriesByPop(m.con, limit));
            for (Country c : countriesByPop)
            {
                System.out.println(c.toString());
            }
        }
        // otherwise proceed without a limit.
        else
        {
            //create array list to store countries and print each country out
            ArrayList<Country> countriesByPop = new ArrayList<>(Country.getCountriesByPop(m.con));
            System.out.println("countries in the world filtered by population:");
            for (Country c : countriesByPop) {
                System.out.println(c.toString());
            }
        }
    }

    /**
     * Feature 2. display every country in a continent
     * ordered by population descending
     *
     * @param m the object m to create a database connection
     */
    public static void feature2and5(Main m)
    {
        // initialise scanner variable and receive decision on continents list
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to see a continents countries sorted by population? (yes/no)");
        String userChoice = scan.nextLine();

        // loop while user wants to see continents list
        while (!userChoice.equals("no")) {
            // receive continent to see
            System.out.println(continentMessage);
            String continent = scan.nextLine();

            // create array list and assign countries in chosen continent using Country method
            ArrayList<Country> countriesByPopContinent = new ArrayList<>(Country.getCountriesByPopContinent(m.con, continent));
            System.out.println("countries in " + continent + " filtered by population:");
            for (Country c : countriesByPopContinent) {
                System.out.println(c.toString());
            }
            // ask user if they'd like to continue
            System.out.println("would you like to see another continent?");
            userChoice = scan.nextLine();
            if (userChoice.equals("no"))
            {
                break;
            }
        }
    }

    /**
     * Feature 3. display every country in a region
     * ordered by population descending
     *
     * @param m the object m to create a database connection
     */
    public static void feature3and6(Main m)
    {
        // process will be same as continent simply replacing the continents with regions.
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to see a regions countries sorted by population? (yes/no)");
        String regionsChoice = scan.nextLine();

        // loop while user wants to see region list
        while (!regionsChoice.equals("no")) {
            // receive region to see
            System.out.println(regionsMessage);
            String region = scan.nextLine();

            // create array list and assign countries in chosen region using Country method
            ArrayList<Country> countriesByPopRegion = new ArrayList<>(Country.getCountriesByPopRegion(m.con, region));
            System.out.println("countries in " + region + " filtered by population:");
            for (Country c : countriesByPopRegion) {
                System.out.println(c.toString());
            }
            // ask user if they'd like to continue
            System.out.println("would you like to see another region?");
            regionsChoice = scan.nextLine();
            if (regionsChoice.equals("no"))
            {
                break;
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