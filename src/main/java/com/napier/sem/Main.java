package com.napier.sem;

import java.io.Console;
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
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        // create new main and begin connection process to database
        Main m = new Main();
        m.connect();
        //creating arraylist to store result of countries by population and printing each country out
        ArrayList<Country> countriesByPop = new ArrayList<>(Country.getCountriesByPop(m.con));
        System.out.println("countries in the world filtered by population:");
        for (Country c : countriesByPop)
        {
            System.out.println(c.toString());
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to see a continents countries sorted by population? (yes/no)");
        String userChoice = scan.nextLine();

        while (!userChoice.equals("no")) {
            System.out.println("please enter one of the following continents: \n Africa \n Antarctica \n Asia \n Europe \n Oceania \n North America \n South America \n this is case sensitive!\n");
            String continent = scan.nextLine();

            ArrayList<Country> countriesByPopContinent = new ArrayList<>(Country.getCountriesByPopContinent(m.con, continent));
            System.out.println("countries in " + continent + " filtered by population:");
            for (Country c : countriesByPopContinent) {
                System.out.println(c.toString());
            }
            System.out.println("would you like to see another continent?");
            userChoice = scan.nextLine();
            if (userChoice.equals("no"))
            {
                break;
            }
        }
        m.disconnect();
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