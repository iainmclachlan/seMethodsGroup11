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
        a.connect("localhost:33060");

        a.getPopulationDESC();
        a.getCityPopulationDESC();

        a.getCityPopulationByID(2806);

        a.getCountryPopulationByCode("AIA");

        a.getWorldPopulation();

        a.getCityPopulation();

        //Disconnect from MySQL
        a.disconnect();
    }

    private Connection con = null;

    public void connect(String location)
    {
        try
        {
            // Load Database driver
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
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
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

    public City getCityPopulationDESC()
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
                ct.city_name = resultSet.getString("City.Name");
                ct.city_population = resultSet.getInt("City.Population");

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


    public City getCityPopulationByID(int ID)
    {
        System.out.println("Enter City ID\n");

        try
        {
            /* Create a SQL statement */
            Statement stmt = con.createStatement();

            /* Create string for SQL statement */
            String strSelect;
            strSelect = "SELECT ID,Name,Population FROM city WHERE ID =" + ID;

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            System.out.println("LISTING...");

            if (resultSet.next())
            {
                City ct = new City();
                ct.ID = resultSet.getInt("City.ID");
                ct.city_name = resultSet.getString("City.Name");
                ct.city_population = resultSet.getInt("City.Population");
                System.out.println("City ID : " + ct.ID + " Name: " +ct.city_name + " Population: " + ct.city_population);
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

    public Country getCountryPopulationByCode(String Code)
    {
        System.out.println("Enter Country Code\n");
        try
        {
            /* Create a SQL statement */
            Statement stmt = con.createStatement();

            /* Create string for SQL statement */
            String strSelect;
            strSelect = "SELECT Code,Name,Population FROM country WHERE Code =" + Code;

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            System.out.println("LISTING...");

            if (resultSet.next())
            {
                Country cty = new Country();
                cty.country_code = resultSet.getString("country_code.Code");
                cty.country_name = resultSet.getString("country_name.Name");
                cty.country_population = resultSet.getInt("country_population.Population");
                System.out.println("Country Code : " + cty.country_code + " Name: " +cty.country_name + " Population: " + cty.country_population);
                return cty;


            } else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country Population");
            return null;
        }
    }

    public Country getWorldPopulation()
    {
        System.out.println("Population of the world.\n");

        try
        {
            /* Create a SQL statement */
            Statement stmt = con.createStatement();

            /* Create string for SQL statement */
            String strSelect;
            strSelect = "SELECT SUM(Population) FROM country";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            System.out.println("LISTING...");

            if (resultSet.next())
            {
                Country cty = new Country();
                cty.country_population = resultSet.getInt("Country.Population");
                System.out.println("World Population: " + cty.country_population);
                return cty;

            } else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country Population");
            return null;
        }
    }

    public City getCityPopulation()
    {
        System.out.println("Population of the Cities.\n");

        try
        {
            /* Create a SQL statement */
            Statement stmt = con.createStatement();

            /* Create string for SQL statement */
            String strSelect;
            strSelect = "SELECT SUM(Population) FROM city";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            System.out.println("LISTING...");

            if (resultSet.next())
            {
                City ct = new City();
                ct.city_population = resultSet.getInt("City.Population");
                System.out.println("Cities Population: " + ct.city_population);
                return ct;

            } else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Cities Population");
            return null;
        }
    }

    public Country getPopulationDESC()
    {
        System.out.println("All the countries in the world organised by largest population to smallest.\n");
        try
        {
            /* Create a SQL statement */
            Statement stmt = con.createStatement();

            /* Create string for SQL statement */
            String strSelect;
            strSelect = "SELECT country_code ,Name,country_population FROM country ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            ResultSetMetaData resultSetMeta = resultSet.getMetaData();
            System.out.println("LISTING...");
            int colNum = resultSetMeta.getColumnCount();

            if (resultSet.next())
            {
                Country ctr = new Country();
                ctr.country_code = resultSet.getString("Country.Code");
                ctr.country_name = resultSet.getString("Country.Name");
                ctr.country_population = resultSet.getInt("Country.Population");

                while(resultSet.next()) {
                    for (int i = 1; i <= colNum; i++)
                    {
                        if (i > 1) System.out.print(", ");
                        String columnValue = resultSet.getString(i);
                        System.out.print(resultSetMeta.getColumnName(i) + " : " + columnValue);
                    }
                    System.out.println("");
                }
                return ctr;
            } else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country Population");
            return null;
        }
    }
}


