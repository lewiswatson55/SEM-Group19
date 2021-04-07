package com.napier.sem;

/**
 * Class that represents a record from a report.
 *
 * @author  Lewis Watson
 * @version 1.0
 * @since   2021-03-13
 */
public class ReportRecord
{
    /**
     * Record's Name (Could be Country, Region, Continent, etc)
     */
    private String _Name;

    /**
     * Population within the cities
     */
    private Long _populationInCity;

    /**
     * Population outwith the cities
     */
    private Long _populationOutCity;

    //Getters

    /**
     * Returns value of Name
     */
    public String getName(){
        return _Name;
    }

    /**
     * Returns value of _populationInCity
     */
    public Long getPopulationInCity(){
        return _populationInCity;
    }

    /**
     * Returns value of _populationOutCity
     */
    public Long getPopulationOutCity(){
        return _populationOutCity;
    }

    //Setters

    /**
     * Sets Name Property of Record
     * @param Name Records Name
     */
    public void setName(String Name){
        _Name = Name;
    }

    /**
     * Sets populationInCity Property of Record
     * @param populationInCity Records Population in cities.
     */
    public void setPopulationInCity(Long populationInCity){
        _populationInCity = populationInCity;
    }

    /**
     * Sets populationOutCity Property of Record
     * @param populationOutCity Records Population in cities.
     */
    public void setPopulationOutCity(Long populationOutCity){
        _populationOutCity = populationOutCity;
    }

}