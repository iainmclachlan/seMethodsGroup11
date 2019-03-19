package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        //Connect to MySQL
        a.connect();

        a.getPopulation();

        //Disconnect from MySQL
        a.disconnect();
    }

    private Connection con = null;

    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
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
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
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

    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public City getPopulation()
    {
        System.out.println("All the cities in the world organised by largest population to smallest.\n");
        try
        {
            /* Create a SQL statement */
            Statement stmt = con.createStatement();

            /* Create string for SQL statement */
            String strSelect;
            strSelect = "SELECT ID,Name,Population FROM city ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            ResultSetMetaData resultSetMeta = resultSet.getMetaData();
            System.out.println("LISTING...");
            int colNum = resultSetMeta.getColumnCount();

            if (resultSet.next())
            {
                City ct = new City();
                ct.ID = resultSet.getInt("City.ID");
                ct.name = resultSet.getString("City.Name");
                ct.population = resultSet.getInt("City.Population");

                while(resultSet.next()) {
                    for (int i = 1; i <= colNum; i++)
                    {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = resultSet.getString(i);
                        System.out.print(resultSetMeta.getColumnName(i) + " : " + columnValue);
                    }
                    System.out.println("");
                }
                return ct;
            } else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City Population");
            return null;
        }
    }
}


