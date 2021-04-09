package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.Console;
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
        cnt.setCode("CHN");
        cnt.setName("China");
        cnt.setContinent("Asia");
        cnt.setRegion("Eastern Asia");
        cnt.setPopulation(1277558000);
        cnt.setCapital("1819");
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
        ccy.setName("San Juan");
        ccy.setCountryCode("PRI");
        ccy.setDistrict("San Juan");
        ccy.setPopulation(434374);
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
        cnt.setLanguage("English");
        cnt.setPercentage(50);
        language.add(cnt);
        app.printLanguage(language);
    }

    @Test
    void testLanguagesToString() {
        Language cnt = new Language();
        cnt.setLanguage("English");
        cnt.setPercentage(50);
        System.out.println(cnt.toString());
    }

    @Test
    void testLanguagesFullConstructor() {
        Language cnt = new Language(501, "English", 0.5f);
        System.out.println(cnt.toString()); //For Review
    }

}
