package com.napier.sem;

/**
 * Class that represents a Country.
 *
 * @author  Lee, Lewis Watson
 * @version 2.0
 * @since   2021-04-01
 */
public class Country
{

    // Class Properties
    /**
     * Country Code
     */
    private String code;

    /**
     * Country Name
     */
    private String name;

    /**
     * Continent
     */
    private String continent;

    /**
     * Country Region
     */
    private String region;
    /**
     * Population
     */
    private int population;

    /**
     * Capital
     */
    private String capital;

    // Constructors
    /**
     * Blank Country Constructor
     */
    public Country() {}

    /**
     * Country Constructor
     * @param code Country's Code
     * @param name Country's Name
     * @param continent Country's Continent
     * @param region Country's Region
     * @param population Country's Population
     * @param capital Country's Capital
     */
    public Country(String code, String name, String continent, String region, int population, String capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
    }


    // Getters and Setters
    /**
     * Returns code property
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets code property
     * @param code Country's Country Code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns name property
     */
    public String getName() {
        return name;
    }

    /**
     * Sets Name Property
     * @param name Country's Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns continent property
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Sets continent property
     * @param continent
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Returns region property
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets region property
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Returns population property
     */
    public int getPopulation() {
        return population;
    }

    /**
     * RSets population property
     * @param population
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * Returns capital property
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Sets capital property
     * @param capital
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * ToString Method for Country Class
     */
    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", population=" + population +
                ", capital='" + capital + '\'' +
                '}';
    }
}