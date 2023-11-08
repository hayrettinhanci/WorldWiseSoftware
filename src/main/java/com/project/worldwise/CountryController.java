package com.project.worldwise;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CountryController {
    CountryService countryService;


    @PostMapping("country-details")
    public String saveCountryDetails(@RequestBody List<Country> countries) {
        System.out.println("country list:"+countries);
        for (Country country : countries) {
            //countryDetailsRepository.save(country);
           // if(country.getCountryName().equals("Turkey")) {
               // country.setCountryName("Kurdistand");
            //}

            System.out.println(country.getId()+ " " + country.getCountryName() + " " + country.getPopulation() + " " + country.getNumberOfCities() + " " + country.getTemperature() + " " + country.getBriefInformation());

            countryService.saveCountry(country);
        }
        return "Data Inserted";
    }

    @GetMapping("countries")
    public List<Country> getCountries() {
        return countryService.getCountries();
    }

}