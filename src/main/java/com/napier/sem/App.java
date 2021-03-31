package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Extract country information
        //ArrayList<Country> country = a.getCountry();

        //print country information
        //a.printCountries(country);

        // City information
        //ArrayList<City> city = a.getCity();

        // print city information
        //a.printCities(city);

        // City information
        //ArrayList<CapitalCity> city = a.getCapitalCity();

        // print city information
        //a.printCapitalCities(city);

        // Language information
        ArrayList<Language> language = a.getLanguage();

        //print language information
        a.printLanguage(language);

        // Disconnect from database
        a.disconnect();
    }
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
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

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public ArrayList<Country> getCountry()
    {
        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                                + "FROM country ORDER BY country.population DESC";

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Extract employee information
                ArrayList<Country> country = new ArrayList<Country>();
                while (rset.next())
                {
                    Country cnt = new Country();
                    cnt.code = rset.getString("country.code");
                    cnt.name = rset.getString("country.name");
                    cnt.continent = rset.getString("country.continent");
                    cnt.region = rset.getString("country.region");
                    cnt.population = rset.getInt("country.population");
                    cnt.capital = rset.getString("country.capital");
                    country.add(cnt);
                }
                return country;

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * Prints a list of countries.
     * @param country The list of countries to print.
     */

    public void printCountries(ArrayList<Country> country)
    {
        // Check countries is not null
        if (country == null)
        {
            System.out.println("No countries");
            return;
        }

        // Print header
        System.out.println(String.format("%-40s %-40s %-40s %-40s %-40s %-40s", "Code", "Name", "Continent", "Region", "Population", "Capital"));
        // Loop over all countries in the list
        for (Country cnt : country)
        {
            if (cnt == null)
                continue;
            String cnt_string =
                    String.format("%-40s %-40s %-40s %-40s %-40s %-40s",
                            cnt.code, cnt.name, cnt.continent, cnt.region, cnt.population, cnt.capital);
            System.out.println(cnt_string);
        }
    }




    public ArrayList<Language> getLanguage()
    {
        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "SELECT countrylanguage.Language, countrylanguage.Percentage, country.Name "
                                + "FROM countrylanguage, country WHERE countrylanguage.Language = 'English' ORDER BY countrylanguage.Percentage DESC;";

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Extract employee information
                ArrayList<Language> language = new ArrayList<Language>();
                while (rset.next())
                {
                    Language cnt = new Language();
                    cnt.Name = rset.getString("country.Name");
                    cnt.language = rset.getString("countryLanguage.Language");
                    cnt.percentage = rset.getInt("countryLanguage.percentage");
                    language.add(cnt);
                }
                return language;

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get language details");
            return null;
        }
    }

    public ArrayList<CapitalCity> getCapitalCity()
    {
        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "SELECT Name, CountryCode, District, Population\n" +
                                "FROM city\n" +
                                "WHERE city.ID IN ( SELECT capital FROM country WHERE continent = 'Asia')\n" +
                                "ORDER BY Population DESC\n LIMIT 0,5;";

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Extract city information
                ArrayList<CapitalCity> city = new ArrayList<CapitalCity>();
                while (rset.next())
                {
                    CapitalCity ccy = new CapitalCity();
                    ccy.Name = rset.getString("city.Name");
                    ccy.CountryCode = rset.getString("city.CountryCode");
                    ccy.District = rset.getString("city.District");
                    ccy.Population = rset.getInt("city.Population");
                    city.add(ccy);
                }
                return city;

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital city details");
            return null;
        }
    }


    /**
     * Prints languages
     */
    public void printLanguage(ArrayList<Language> language)
    {
        // Check language is not null
        if (language == null)
        {
            System.out.println("No languages");
            return;
        }

        // Print header
        System.out.println(String.format("%-40s %-40s %-40s", "Name", "language", "Percentage"));
        // Loop over all languages in the list
        for (Language cnt : language)
        {
            if (cnt == null)
                continue;

            String cnt_string =
                    String.format("%-40s %-40s %-40s",
                          cnt.Name, cnt.language, cnt.percentage);
            System.out.println(cnt_string);
        }
    }

    /**
     * Prints a list of Capital Cities.
     */
    public void printCapitalCities(ArrayList<CapitalCity> city)
    {
        // Check capital city is not null
        if (city == null)
        {
            System.out.println("No capital cities");
            return;
        }
        // Print header
        System.out.println(String.format("%-40s %-40s %-40s %-40s ", "Name", "CountryCode", "District", "Population"));
        // Loop over all capital cities in the list
        for (CapitalCity ccy : city)
        {
            if (ccy == null)
                continue;
            String ccy_string =
                    String.format("%-40s %-40s %-40s %-40s",
                            ccy.Name, ccy.CountryCode, ccy.District, ccy.Population);
            System.out.println(ccy_string);
        }
    }
}