-All the countries in the world organised by largest population to smallest.

    strSelect = "SELECT Code, Name, Population FROM country ORDER BY Paopulation DESC";

    World wd = new World();
                    wd.code = resultSet.getInt("country.Code");
                    wd.name = resultSet.getString("country.Name");
                    wd.population = resultSet.getInt("country.Population");

-All the countries in a continent organised by largest population to smallest.

    strSelect = "SELECT Code, Name, Population, Continent FROM country GROUP BY Continent ORDER BY Population DESC";

    Continent ctnt = new Continent();
                    ctnt.ID = resultSet.getInt("Continent.ID");
                    ctnt.name = resultSet.getString("Continent.Name");
                    ctnt.population = resultSet.getInt("Continent.Population");

-All the countries in a region organised by largest population to smallest.

    strSelect = "SELECT Code, Name, Population, Region FROM country GROUP BY Region ORDER BY Population DESC";

    Region rgn = new Region();
                    rgn.ID = resultSet.getInt("Region.ID");
                    rgn.name = resultSet.getString("Region.Name");
                    rgn.population = resultSet.getInt("Region.Population");

-The top N populated countries in the world where N is provided by the user.

    strSelect = "SELECT Code, Name, Population FROM country ORDER BY Population HAVING COUNT(Code) = n";
    
    Country cnt = new Country();
                      cnt.ID = resultSet.getInt("Country.ID");
                      cnt.name = resultSet.getString("Country.Name");
                      cnt.population = resultSet.getInt("Country.Population");

-The top N populated countries in the world where N is provided by the user.

-The top N populated countries in a region where N is provided by the user.

-All the cities in the world organised by largest population to smallest. -DONE-

    strSelect = "SELECT ID,Name,Population FROM City ORDER BY Population DESC";

    City ct = new City();
                    ct.ID = resultSet.getInt("City.ID");
                    ct.name = resultSet.getString("City.Name");
                    ct.population = resultSet.getInt("City.Population");

-All the cities in a continent organised by largest population to smallest.

    strSelect = "SELECT ID,Name,Population FROM Continent WHERE "add something tomorrow" ORDER BY Population DESC";

    Continent ctnt = new Continent();
                    ctnt.ID = resultSet.getInt("Continent.ID");
                    ctnt.name = resultSet.getString("Continent.Name");
                    ctnt.population = resultSet.getInt("Continent.Population");

-All the cities in a region organised by largest population to smallest.
    
    
-All the cities in a country organised by largest population to smallest.

-All the cities in a district organised by largest population to smallest.

-The top N populated cities in the world where N is provided by the user.

-The top N populated cities in a continent where N is provided by the user.

-The top N populated cities in a region where N is provided by the user.

-The top N populated cities in a country where N is provided by the user.

-The top N populated cities in a district where N is provided by the user.

-All the capital cities in the world organised by largest population to smallest.

-All the capital cities in a continent organised by largest population to smallest.

-All the capital cities in a region organised by largest to smallest.

-The top N populated capital cities in the world where N is provided by the user.

-The top N populated capital cities in a continent where N is provided by the user.

-The top N populated capital cities in a region where N is provided by the user.

-The population of people, people living in cities, and people not living in cities in each continent.

-The population of people, people living in cities, and people not living in cities in each region.

-The population of people, people living in cities, and people not living in cities in each country.

The Program will also be able to display the following Information:
-The population of the world. -DONE-

    strSelect = "SELECT SUM(Population) FROM country;

    World wd = new World();
                    wd.population = resultSet.getInt("Continent.Population");

-The population of a continent.

    strSelect = "SELECT SUM(Population) FROM country WHERE continent = "continent name by the user";

    Continent ctnt = new Continent();
                    ctnt.population = resultSet.getInt("Continent.Population");

-The population of a region.

    strSelect = "SELECT SUM(Population) FROM country WHERE region = "region name by the user" ;

    Region rgn = new Region();
                    rgn.population = resultSet.getInt("Region.Population");

-The population of a country.

    strSelect = "SELECT Population FROM country WHERE country = "country name by the user";

    Country cry = new Country();
                    cry.population = resultSet.getInt("Country.Population");

-The population of a district.

    strSelect = "SELECT SUM(Population) FROM city WHERE District = "district name by the user";

    District dtct = new District();
                    dtct.population = resultSet.getInt("District.Population");

-The population of a city.

    strSelect = "SELECT Population FROM city WHERE Name = "name provided by the user";

        City ct = new City();
                        ct.population = resultSet.getInt("City.Population");

