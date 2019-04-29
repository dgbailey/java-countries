package com.countries.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController
{



    // localhost:2019/population/size/people/{int people}
    @GetMapping(value = "/size/{people}")
    public ResponseEntity<?> getCountriesPopulation (@PathVariable int people)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.myCountries
                .findCountries(e-> e.getPopulation() >= people);


        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);

    }

    // localhost:2019/population//size/people/min
    @GetMapping(value = "/size/min")
    public ResponseEntity<?> getPopulationMin()
    {
        CountriesApplication.myCountries.countryList
                    .sort((e1,e2) -> e1.getPopulation() - e2.getPopulation());


        return new ResponseEntity<>(CountriesApplication.myCountries.countryList.get(0), HttpStatus.OK);
    }

    // localhost:2019/population/size/max
    @GetMapping(value = "/size/max")
    public ResponseEntity<?> getPopulationMax()
    {
        CountriesApplication.myCountries.countryList
                .sort((e1,e2) -> e2.getPopulation() - e1.getPopulation());


        return new ResponseEntity<>(CountriesApplication.myCountries.countryList.get(0), HttpStatus.OK);
    }

    // localhost:2019/population/size/median
    @GetMapping(value = "/size/median")
    public ResponseEntity<?> getPopulationMedian()
    {
        if(CountriesApplication.myCountries.countryList.size() %2 == 0)
        {
            int tmpIndex = CountriesApplication.myCountries.countryList.size()/2;
            CountriesApplication.myCountries.countryList
                    .sort((e1,e2) -> e1.getPopulation() - e2.getPopulation());


            return new ResponseEntity<>(CountriesApplication.myCountries.countryList.get(tmpIndex), HttpStatus.OK);
        }
        else {
            Double tmpIndex = ((CountriesApplication.myCountries.countryList.size()/2) + .5);
            CountriesApplication.myCountries.countryList
                    .sort((e1,e2) -> e1.getPopulation() - e2.getPopulation());


            return new ResponseEntity<>(CountriesApplication.myCountries.countryList.get(tmpIndex.intValue()), HttpStatus.OK);
        }


    }
}
