package com.napier.sem;

import java.text.DecimalFormat;

/**
 * Class that represents a Language.
 *
 * @author  Kristiyan Tanev, Lewis Watson
 * @version 2.0
 * @since   2021-04-01
 */
public class Language
{

    //Properties

    /**
     * Population of Speakers
     */
    private long _population;

    /**
     * Language
     */
    private String _language;

    /**
     * Percentage of the world population
     */
    private float _percentage;


    //Constructors

    /**
     * Blank Language Constructor
     */
    public Language() {
    }

    /**
     * Returns value of _population
     */
    public Language(long population, String language, float percentage) {

    }

    // Getters
    /**
     * Returns value of _population
     */
    public long getPopulation(){
        return _population;
    }

    /**
     * Returns value of _language
     */
    public String getLanguage(){
        return _language;
    }

    /**
     * Returns value of _percentage
     */
    public float getPercentage(){
        return _percentage;
    }

    // Setters
    /**
     * Sets private population property
     * @param population population of speakers
     */
    public void setPopulation(long population){
        _population = population;
    }

    /**
     * Sets private language property
     * @param language language name
     */
    public void setLanguage(String language) {
        _language = language;
    }

    /**
     * Sets private population property
     * @param percentage percentage of world population
     */
    public void setPercentage(float percentage) {
        _percentage = percentage;
    }

    //ToString Method

    /**
     * Returns string representation of class.
     */
    @Override
    public String toString() {
        return "Language{" +
                "_population=" + _population +
                ", _language='" + _language + '\'' +
                ", _percentage=" + _percentage +
                '}';
    }
}
