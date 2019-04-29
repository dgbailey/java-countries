package com.countries.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class AgeController
{



    // localhost:2019/age/age/{age}
    @GetMapping(value = "/age/{age}")
    public ResponseEntity<?> getAgeMedianGreater (@PathVariable int age)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.myCountries
                .findCountries(e-> e.getMedianAge() >= age);


        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);

    }

    // localhost:2019/age/min
    @GetMapping(value = "/age/min")
    public ResponseEntity<?> getAgeMin()
    {
        CountriesApplication.myCountries.countryList
                .sort((e1,e2) -> e1.getMedianAge() - e2.getMedianAge());


        return new ResponseEntity<>(CountriesApplication.myCountries.countryList.get(0), HttpStatus.OK);
    }

    // localhost:2019/age/age/max
    @GetMapping(value = "/age/max")
    public ResponseEntity<?> getAgeMax()
    {
        CountriesApplication.myCountries.countryList
                .sort((e1,e2) -> e2.getMedianAge() - e1.getMedianAge());


        return new ResponseEntity<>(CountriesApplication.myCountries.countryList.get(0), HttpStatus.OK);
    }

    // localhost:2019/age/age/median
    @GetMapping(value = "/age/median")
    public ResponseEntity<?> getAgeMedian()
    {
        if(CountriesApplication.myCountries.countryList.size() %2 == 0)
        {
            int tmpIndex = CountriesApplication.myCountries.countryList.size()/2;
            CountriesApplication.myCountries.countryList
                    .sort((e1,e2) -> e1.getMedianAge() - e2.getMedianAge());


            return new ResponseEntity<>(CountriesApplication.myCountries.countryList.get(tmpIndex), HttpStatus.OK);
        }
        else {
            Double tmpIndex = ((CountriesApplication.myCountries.countryList.size()/2) + .5);
            CountriesApplication.myCountries.countryList
                    .sort((e1,e2) -> e1.getMedianAge() - e2.getMedianAge());


            return new ResponseEntity<>(CountriesApplication.myCountries.countryList.get(tmpIndex.intValue()), HttpStatus.OK);
        }


    }
}
