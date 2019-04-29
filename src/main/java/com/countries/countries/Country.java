package com.countries.countries;

public class Country
{
    private String name;
    private Integer population;
    private Integer lms;
    private Integer medianAge;

    public Country(String name, Integer population, Integer lms, Integer medianAge) {
        this.name = name;
        this.population = population;
        this.lms = lms;
        this.medianAge = medianAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getLms() {
        return lms;
    }

    public void setLms(Integer lms) {
        this.lms = lms;
    }

    public Integer getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(Integer medianAge) {
        this.medianAge = medianAge;
    }
}
