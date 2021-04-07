package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * The App class is the main entry point into our code.
 * This is where any queries or data manipulation occurs.
 *
 * @author  Kristiyan Tanev, Lee Shaw, Amy Harvey, Lewis Watson
 * @version 1.0
 * @since   2021-02-03
 */
public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        if (args.length < 1)
        {
            a.connect("localhost:3306");
        }
        else
        {
            a.connect(args[0]);
        }

        // Extract country information
        // ArrayList<Country> country = a.getCountry();

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

        // Population in/out cities
        ArrayList<ReportRecord> Report = a.populationCityInOut(1);

        //Print Report
        a.printReport(Report);

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * This is the method used to attempt to connect to the program Database.
     * Upon failing to connect the program will try again (ten times).
     * @param location Database IP/Address
     */
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

    /**
     * This is the method used to return an array list of Countries.
     * Dependant on the SQL used in the method.
     *
     * @return ArrayList<Country> List of Countries
     */
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
     * This is the method used to return an array list of Cities.
     * Dependant on the SQL used in the method.
     *
     * @return ArrayList<Country> List of Cities
     */
    public ArrayList<City> getCity()
    {
        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "SELECT city.Name, city.CountryCode, city.District, city.Population "
                                + "FROM city,country WHERE country.Code = city.CountryCode AND country.Region = 'Middle East' ORDER BY city.Population DESC;";

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Extract employee information
                ArrayList<City> city = new ArrayList<City>();
                while (rset.next())
                {
                    City cnt = new City();
                    cnt.Name = rset.getString("city.Name");
                    cnt.CountryCode = rset.getString("city.CountryCode");
                    cnt.District = rset.getString("city.District");
                    cnt.Population = rset.getInt("city.Population");
                    city.add(cnt);
                }
                return city;

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * This is the method used to return an array list of Capital Cities.
     * Dependant on the SQL used in the method.
     *
     * @return ArrayList<Country> List of Capital Cities.
     */
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
                                "WHERE city.ID IN ( SELECT capital FROM country WHERE region = \"Caribbean\" )\n" +
                                "ORDER BY Population DESC\n";

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
     * Prints a list of countries.
     * @param country Array List of Countries to be printed to system out.
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


    /**
     * Prints a list of cities.
     * @param city Array List of Cities to be printed to system out.
     */
    public void printCities(ArrayList<City> city)
    {
        // Check city is not null
        if (city == null)
        {
            System.out.println("No cities");
            return;
        }

        // Print header
        System.out.println(String.format("%-40s %-40s %-40s %-40s ", "Name", "CountryCode", "District", "Population"));
        // Loop over all cities in the list
        for (City cnt : city)
        {
            if (cnt == null)
                continue;

            String cnt_string =
                    String.format("%-40s %-40s %-40s %-40s",
                            cnt.Name, cnt.CountryCode, cnt.District, cnt.Population);
            System.out.println(cnt_string);
        }
    }

    /**
     * Prints a list of Capital Cities.
     * @param city Array List of Capital Cities to be printed to system out.
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

    /**
     * Returns an ArrayList as a report for
     * @param reportType Report Type, 0: Countries, 1: Regions, 2: Continent
     *
     */
    public ArrayList<ReportRecord> populationCityInOut(int reportType) {

        String chosenQuery;

        // Work out which query is to be run
        if (reportType==0) {
            chosenQuery = "SELECT populationInCities, populationNotCities, Name\n" +
                    "FROM (\n" +
                    "SELECT country.Population - SUM(city.population) as populationNotCities, city.CountryCode, SUM(city.Population) as populationInCities, country.Name as Name\n" +
                    "FROM city\n" +
                    "JOIN country ON city.CountryCode=country.Code\n" +
                    "GROUP BY city.CountryCode\n" +
                    "\t) as country_table";
        }
        else if (reportType==1)
        {
            chosenQuery = "SELECT SUM(populationInCities_Country) as populationInCities, SUM(populationNotCities_Country) as populationNotCities, Name\n" +
                    "FROM (\n" +
                    "SELECT country.Population - SUM(city.population) as populationNotCities_Country, city.CountryCode, SUM(city.Population) as populationInCities_Country, country.region as Name\n" +
                    "FROM city\n" +
                    "JOIN country ON city.CountryCode=country.Code\n" +
                    "GROUP BY city.CountryCode\n" +
                    ") as country_table\n" +
                    "GROUP BY Name";
        }
        else if (reportType==2)
        {
            chosenQuery = "SELECT SUM(populationInCities_Country) as populationInCities, SUM(populationNotCities_Country) as populationNotCities, Name\n" +
                    "FROM (\n" +
                    "SELECT country.Population - SUM(city.population) as populationNotCities_Country, city.CountryCode, SUM(city.Population) as populationInCities_Country, country.continent as Name\n" +
                    "FROM city\n" +
                    "JOIN country ON city.CountryCode=country.Code\n" +
                    "GROUP BY city.CountryCode\n" +
                    ") as country_table\n" +
                    "GROUP BY Name";
        } else {
            System.out.println("Invalid Population in/out Cities Report Type");
            return null;
        }

        // Run Query Against DB
        try {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect = chosenQuery;

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Extract city information
                ArrayList<ReportRecord> Report = new ArrayList<ReportRecord>();
                while (rset.next()) {
                    ReportRecord record = new ReportRecord();
                    record.setName(rset.getString("Name"));
                    record.setPopulationInCity(rset.getLong("populationInCities"));
                    record.setPopulationInCity(rset.getLong("populationNotCities"));
                    Report.add(record);
                }
                return Report;

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to generate report...");
            return null;
        }
    }

    /**
     * Prints a list of Capital Cities.
     * @param Report Array List (Report) of Records from )
     */
    public void printReport(ArrayList<ReportRecord> Report)
    {
        // Check report is not null
        if (Report == null)
        {
            System.out.println("Report is null.");
            return;
        }
        // Print header
        System.out.println(String.format("%-40s %-40s %-40s ", "Name", "Population in City", "Population outwith City"));
        // Loop over all records in the report
        for (ReportRecord record : Report)
        {
            if (record == null)
                continue;
            String record_string =
                    String.format("%-40s %-40s %-40s %-40s",
                            record.getName(), record.getPopulationInCity(), record.getPopulationOutCity());
            System.out.println(record_string);
        }
    }

}