package com.countries.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryController
{
    // localhost:2019/names/all
    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllCountries() {
        CountriesApplication.myCountries.countryList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return new ResponseEntity<>(CountriesApplication.myCountries.countryList, HttpStatus.OK);
    }


    // localhost:2019/data/employees/s
    @GetMapping(value = "/start/{letter}")
    public ResponseEntity<?> getCountriesLetter (@PathVariable char letter)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.myCountries
                .findCountries(e-> e.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnCountries.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));

        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/size/{number}")
    public ResponseEntity<?> getCountriesSizeAlph (@PathVariable int number)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.myCountries
                .findCountries(e-> e.getName().length() >= number);
        rtnCountries.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));

        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }
}