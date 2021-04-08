package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class MyTest {

    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void printCountriesNull()
    {
        app.printCountries(null);
    }

    @Test
    void printCountriesEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountries(countries);
    }

    @Test
    void printCountriesContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.printCountries(countries);
    }

    @Test
    void printCountries()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country cnt = new Country();
        cnt.code = "CHN";
        cnt.name = "China";
        cnt.continent = "Asia";
        cnt.region = "Eastern Asia";
        cnt.population = 1277558000;
        cnt.capital = "1819";
        countries.add(cnt);
        app.printCountries(countries);
    }


    @Test
    void printCapitalCityNull()
    {
        app.printCapitalCities(null);
    }

    @Test
    void printCapitalCityEmpty()
    {
        ArrayList<CapitalCity> capitalCities = new ArrayList<CapitalCity>();
        app.printCapitalCities(capitalCities);
    }

    @Test
    void printCapitalCityContainsNull()
    {
        ArrayList<CapitalCity> capitalCities = new ArrayList<CapitalCity>();
        capitalCities.add(null);
        app.printCapitalCities(capitalCities);
    }

    @Test
    void printCapitalCity()
    {
        ArrayList<CapitalCity> capitalCities = new ArrayList<CapitalCity>();
        CapitalCity ccy = new CapitalCity();
        ccy.Name = "San Juan";
        ccy.CountryCode = "PRI";
        ccy.District = "San Juan";
        ccy.Population = 434374;
        capitalCities.add(ccy);
        app.printCapitalCities(capitalCities);
    }
}
