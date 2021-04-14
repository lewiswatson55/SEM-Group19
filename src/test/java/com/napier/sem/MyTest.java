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
    void printCityNull()
    {
        app.printCities(null);
    }

    @Test
    void printCityEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCities(cities);
    }

    @Test
    void printCityContainsNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.printCities(cities);
    }

    @Test
    void printCity()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City ccy = new City();
        ccy.Name = "San Juan";
        ccy.CountryCode = "PRI";
        ccy.District = "San Juan";
        ccy.Population = 434374;
        cities.add(ccy);
        app.printCities(cities);
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

    @Test
    void printLanguageNull()
    {
        app.printLanguage(null);
    }

    @Test
    void printLanguageEmpty()
    {
        ArrayList<Language> language = new ArrayList<Language>();
        app.printLanguage(language);
    }

    @Test
    void printLanguageContainsNull()
    {
        ArrayList<Language> language = new ArrayList<Language>();
        language.add(null);
        app.printLanguage(language);
    }

    @Test
    void printLanguages()
    {
        ArrayList<Language> language = new ArrayList<Language>();
        Language cnt = new Language();
        cnt.language = "English";
        cnt.percentage = 50;
        language.add(cnt);
        app.printLanguage(language);
    }
}
