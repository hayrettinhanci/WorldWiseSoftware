package com.project.worldwise.controller;

import com.project.worldwise.dto.MapToPopulation;
import com.project.worldwise.dto.CountryDTO;
import com.project.worldwise.model.City;
import com.project.worldwise.model.Country;
import com.project.worldwise.repository.CountryRepository;
import com.project.worldwise.service.CityService;
import com.project.worldwise.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CountryController {
    CountryService countryService;
    CityService cityService;
    CountryRepository countryRepository;


    @PostMapping("country-details")
    public String saveCountryDetails(@RequestBody List<Country> countries) {
        System.out.println("country list:" + countries);
        for (Country country : countries) {
            //countryDetailsRepository.save(country);
            // if(country.getCountryName().equals("Turkey")) {
            // country.setCountryName("Kurdistand");
            //}

            System.out.println(country.getId() + " " + country.getCountryName() + " " + country.getPopulation() + " " + country.getNumberOfCities() + " " + country.getTemperature() + " " + country.getBriefInformation());

            countryService.saveCountry(country);
        }
        return "Data Inserted";
    }

    @GetMapping("countries")
    public List<Country> getCountries() {

        return countryService.getCountries();
    }

    @GetMapping("country/{id}")
    public Optional<Country> getCountryById(@PathVariable Long id) {

        return countryService.getCountryById(id);
    }
    @GetMapping("country/findCountry/{cityName}")
    public String getCountryNameByCityName(@PathVariable String cityName) {
        return cityService.getCountryNameByCityName(cityName);
    }

    @GetMapping("country/delete/{id}")
    public String deleteCountryById(@PathVariable Long id) {
        String countryName = countryService.getCountryById(id).get().getCountryName();
        countryService.deleteCountryById(id);
        System.out.println(id + " id numbered " + countryName + " is deleted"); // how can I write here country name automatically
        return "The country with the " + id + " id number was deleted";
    }

    @GetMapping("countries/{population}")
    public List<CountryDTO> getCountriesWithPopulation(@PathVariable int population) {

      return countryService.getCountriesWithPopulation(population);

    }


}


