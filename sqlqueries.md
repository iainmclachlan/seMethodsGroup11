-All the countries in the world organised by largest population to smallest.

    strSelect = "SELECT ID,Name,Population FROM World ORDER BY Population DESC";

    World wd = new World();
                    wd.ID = resultSet.getInt("World.ID");
                    wd.name = resultSet.getString("World.Name");
                    wd.population = resultSet.getInt("World.Population");

-All the countries in a continent organised by largest population to smallest.

    strSelect = "SELECT ID,Name,Population FROM Continent ORDER BY Population DESC";

    Continent ctnt = new Continent();
                    ctnt.ID = resultSet.getInt("Continent.ID");
                    ctnt.name = resultSet.getString("Continent.Name");
                    ctnt.population = resultSet.getInt("Continent.Population");

-All the countries in a region organised by largest population to smallest.

    strSelect = "SELECT ID,Name,Population FROM Region ORDER BY Population DESC";

    Region rgn = new Region();
                    rgn.ID = resultSet.getInt("Region.ID");
                    rgn.name = resultSet.getString("Region.Name");
                    rgn.population = resultSet.getInt("Region.Population");

-The top N populated countries in the world where N is provided by the user.

    strSelect = "SELECT ID, Name, Population FROM Country ORDER BY Population DESC" 
    
    Country cnt = new Country();
                      cnt.ID = resultSet.getInt("Country.ID");
                      cnt.name = resultSet.getString("Country.Name");
                      cnt.population = resultSet.getInt("Country.Population");

-The top N populated countries in the world where N is provided by the user.

-The top N populated countries in a region where N is provided by the user.

-All the cities in the world organised by largest population to smallest.

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
-The population of the world.

    strSelect = "SELECT Population FROM World;

    World wd = new World();
                    wd.population = resultSet.getInt("Continent.Population");

-The population of a continent.

    strSelect = "SELECT Population FROM Continent;

    Continent ctnt = new Continent();
                    ctnt.population = resultSet.getInt("Continent.Population");

-The population of a region.

    strSelect = "SELECT Population FROM Region;

    Region rgn = new Region();
                    rgn.population = resultSet.getInt("Region.Population");

-The population of a country.

    strSelect = "SELECT Population FROM Country;

    Country cry = new Country();
                    cry.population = resultSet.getInt("Country.Population");

-The population of a district.

    strSelect = "SELECT Population FROM District;

    District dtct = new District();
                    dtct.population = resultSet.getInt("District.Population");

-The population of a city.

    strSelect = "SELECT Population FROM City;

        City ct = new City();
                        ct.population = resultSet.getInt("City.Population");

