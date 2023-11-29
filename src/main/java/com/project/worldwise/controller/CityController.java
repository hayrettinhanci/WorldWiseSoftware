 package com.project.worldwise.controller;

import com.project.worldwise.model.City;
import com.project.worldwise.service.CityService;
import com.project.worldwise.service.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class CityController {

    CountryService countryService;
    CityService cityService;

    @PostMapping("city-details")
    public String saveCityDetails(@RequestBody List<City> cities) {
        System.out.println("city list: " + cities);

        for (City city : cities) {
            System.out.println(city.getCityName() + " " + city.getCityPopulation());
            cityService.saveCity(city);
        }
        return "City Details Inserted";
    }

}