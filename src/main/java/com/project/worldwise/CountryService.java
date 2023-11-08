package com.project.worldwise;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CountryService {


    private final CountryRepository countryRepository;

    public void saveCountry(Country country) {
        countryRepository.save(country);
    }

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }



}