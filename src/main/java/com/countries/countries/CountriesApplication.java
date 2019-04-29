package com.countries.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesApplication {

    public static CountryList myCountries;
    public static void main(String[] args) {

        myCountries = new CountryList();
        SpringApplication.run(CountriesApplication.class, args);
    }

}
