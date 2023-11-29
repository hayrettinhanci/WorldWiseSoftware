package com.project.worldwise.service;

import com.project.worldwise.dto.CountryDTO;
import com.project.worldwise.dto.MapToPopulation;
import com.project.worldwise.model.City;
import com.project.worldwise.model.Country;
import com.project.worldwise.repository.CityRepository;
import com.project.worldwise.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class CountryService {


    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    public void saveCountry(Country country) {

        countryRepository.save(country);
    }

    public List<Country> getCountries() {

        return countryRepository.findAll();
    }


    public Optional<Country> getCountryById(Long id) {

        return countryRepository.findById(id);
    }

    public void deleteCountryById(Long id) {
       countryRepository.deleteById(id);

    }
    public List<CountryDTO> getCountriesWithPopulation(int population) {
        List<Country> countries = countryRepository.findAll();
        return MapToPopulation.getCountriesWithPopulation(countries, population);


    }







}