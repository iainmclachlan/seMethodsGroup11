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
        a.connect("35.234.135.51:3306");

        a.getPopulationDESC();

        a.getCityPopulationDESC();

        a.getCityPopulationByID(2806);

        a.getCountryPopulationByCode("AIA");

        a.getWorldPopulation();

        a.getCityPopulation();

        a.getPopulationContinent();

        a.getRegionPopulation();

        a.getDistrictPopulation();

        a.getCountryPopulation();

        a.getContinentPopulationDESC();

        //Disconnect from MySQL
        a.disconnect();
    }

    /**
     * Connects to External or Local SQL Database
     *
     */
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
    /*
    Shows city population in a descending order
     */
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

/*
shows city population from a specific ID
 */
    public City getCityPopulationByID(int ID)
    {
        System.out.println("Get City Population by ID\n");
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
    /*
    shows a country population by a specific code
     */

    public Country getCountryPopulationByCode(String Code)
    {
        System.out.println("Get country population by code ID\n");
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
    /*
    shows world population
     */

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

    /*
    shows city population
     */
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

    /*
    shows all the countries in the world organised by largest population to smallest
     */
    public Country getPopulationDESC()
    {
        System.out.println("All the countries in the world organised by largest population to smallest.\n");
        try
        {
            /* Create a SQL statement */
            Statement stmt = con.createStatement();

            /* Create string for SQL statement */
            String strSelect;
            strSelect = "SELECT Name, Code, Population FROM country ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            ResultSetMetaData resultSetMeta = resultSet.getMetaData();
            System.out.println("LISTING...");
            int colNum = resultSetMeta.getColumnCount();

            if (resultSet.next())
            {
                Country cty = new Country();
                cty.country_code = resultSet.getString("Country.Code");
                cty.country_name = resultSet.getString("Country.Name");
                cty.country_population = resultSet.getInt("Country.Population");

                while(resultSet.next()) {
                    for (int i = 1; i <= colNum; i++)
                    {
                        if (i > 1) System.out.print(", ");
                        String columnValue = resultSet.getString(i);
                        System.out.print(resultSetMeta.getColumnName(i) + " : " + columnValue);
                    }
                    System.out.println("");
                }
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

    /*
    shows population of a continent
     */
    public Country getPopulationContinent()
    {
        System.out.println("Get population continent\n");
        try
        {
            /* Create a SQL statement */
            Statement stmt = con.createStatement();

            /* Create string for SQL statement */
            String strSelect;
            strSelect = "SELECT SUM(Population),Continent FROM country ORDER BY continent";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            ResultSetMetaData resultSetMeta = resultSet.getMetaData();

            System.out.println("LISTING...");
            int colNum = resultSetMeta.getColumnCount();

            if (resultSet.next())
            {
                Country cty = new Country();
                cty.country_continent = resultSet.getString("country_continent.Continent");
                cty.country_population = resultSet.getInt("country_population.Population");
                System.out.println(" Name: " +cty.country_continent + " Population: " + cty.country_population);

                while(resultSet.next()) {
                    for (int i = 1; i <= colNum; i++)
                    {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = resultSet.getString(i);
                        System.out.print(resultSetMeta.getColumnName(i) + " : " + columnValue);
                    }
                    System.out.println("");
                }
                return cty;

            } else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Continents Population");
            return null;
        }
    }

    /*
   shows population of a region
    */
    public Country getRegionPopulation()
    {
        System.out.println("Get region population\n");
        try
        {
            /* Create a SQL statement */
            Statement stmt = con.createStatement();

            /* Create string for SQL statement */
            String strSelect;
            strSelect = "SELECT SUM(Population),Region FROM country SORT BY Region";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            ResultSetMetaData resultSetMeta = resultSet.getMetaData();

            System.out.println("LISTING...");
            int colNum = resultSetMeta.getColumnCount();

            if (resultSet.next())
            {
                Country cty = new Country();
                cty.country_region = resultSet.getString("country_region.Region");
                cty.country_population = resultSet.getInt("country_population.Population");
                System.out.println(" Name: " +cty.country_region + " Population: " + cty.country_population);

                while(resultSet.next()) {
                    for (int i = 1; i <= colNum; i++)
                    {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = resultSet.getString(i);
                        System.out.print(resultSetMeta.getColumnName(i) + " : " + columnValue);
                    }
                    System.out.println("");
                }
                return cty;

            } else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Regions Population");
            return null;
        }
    }

    /*
   shows population of a district
    */
    public City getDistrictPopulation()
    {
        System.out.println("Get district population\n");
        try
        {
            /* Create a SQL statement */
            Statement stmt = con.createStatement();

            /* Create string for SQL statement */
            String strSelect;
            strSelect = "SELECT SUM(Population),District FROM city SORT BY District";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            ResultSetMetaData resultSetMeta = resultSet.getMetaData();

            System.out.println("LISTING...");
            int colNum = resultSetMeta.getColumnCount();


            if (resultSet.next())
            {
                City ct = new City();
                ct.city_district = resultSet.getString("country_district.District");
                ct.city_population = resultSet.getInt("city_population.Population");
                System.out.println(" Name: " +ct.city_district + " Population: " + ct.city_population);

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
            System.out.println("Failed to get District Population");
            return null;
        }
    }

    /*
   shows population of a country
    */
    public Country getCountryPopulation()
    {
        System.out.println("Get population of a country\n");
        try
        {
            /* Create a SQL statement */
            Statement stmt = con.createStatement();

            /* Create string for SQL statement */
            String strSelect;
            strSelect = "SELECT SUM(Population),name FROM country SORT BY name";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            ResultSetMetaData resultSetMeta = resultSet.getMetaData();

            System.out.println("LISTING...");
            int colNum = resultSetMeta.getColumnCount();

            if (resultSet.next())
            {
                Country cty = new Country();
                cty.country_name = resultSet.getString("country_name.Name");
                cty.country_population = resultSet.getInt("country_population.Population");
                System.out.println(" Name: " +cty.country_name + " Population: " + cty.country_population);

                while(resultSet.next()) {
                    for (int i = 1; i <= colNum; i++)
                    {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = resultSet.getString(i);
                        System.out.print(resultSetMeta.getColumnName(i) + " : " + columnValue);
                    }
                    System.out.println("");
                }
                return cty;

            } else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country populations");
            return null;
        }
    }

    /*
  All the countries in a continent organised by largest population to smallest.
   */
    public Country getContinentPopulationDESC()
    {
        System.out.println("All the countries in a continent organised by largest population to smallest.\n");
        try
        {
            /* Create a SQL statement */
            Statement stmt = con.createStatement();

            /* Create string for SQL statement */
            String strSelect;
            strSelect = "SELECT Code, Name, Population, Continent FROM country GROUP BY Continent ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            ResultSetMetaData resultSetMeta = resultSet.getMetaData();

            System.out.println("LISTING...");
            int colNum = resultSetMeta.getColumnCount();

            if (resultSet.next())
            {
                Country cty = new Country();
                cty.country_code = resultSet.getString("country_code.Code");
                cty.country_name = resultSet.getString("country_name.Name");
                cty.country_population = resultSet.getInt("country_population.Population");
                cty.country_continent = resultSet.getString("country_continent.Continent");
                System.out.println(" Code: " +cty.country_code + " Name: " +cty.country_name + " Population: " + cty.country_population + " Continent: " +cty.country_continent);

                while(resultSet.next()) {
                    for (int i = 1; i <= colNum; i++)
                    {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = resultSet.getString(i);
                        System.out.print(resultSetMeta.getColumnName(i) + " : " + columnValue);
                    }
                    System.out.println("");
                }
                return cty;

            } else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get all the countries in a continent organised by largest population to smallest.");
            return null;
        }
    }

}


