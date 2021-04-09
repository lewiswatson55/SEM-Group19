package com.napier.sem;

/**
 * Class that represents a City.
 *
 * @author  Lewis Watson
 * @version 2.0
 * @since   2021-03-13
 */
public class CapitalCity
{
    // Properties
    /**
     * City name
     */
    private String name;

    /**
     * Country Name
     */
    private String countryCode;

    /**
     * District name
     */
    private String district;

    /**
     * City population
     */
    private int population;

    // Constructors
    /**
     * Constructor for city class
     * @param name City Name
     * @param countryCode City's Country Code
     * @param district City's District
     * @param population Population of City
     */
    public CapitalCity(String name, String countryCode, String district, int population) {
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    /**
     * Blank City Constructor
     */
    public CapitalCity() {}

    // Getters and Setters
    /**
     * Returns property name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets property name
     * @param name City's Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns property country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets property country code
     * @param countryCode City's Country Code
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Returns property district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Sets property district
     * @param district City's district
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * Returns property population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Sets property name
     * @param population
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * Returns toString of City
     */
    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
}