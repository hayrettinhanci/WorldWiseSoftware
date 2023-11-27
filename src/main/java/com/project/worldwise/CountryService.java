package com.project.worldwise;

import com.project.worldwise.CountryDTO;
import com.project.worldwise.City;
import com.project.worldwise.Country;
import com.project.worldwise.CityRepository;
import com.project.worldwise.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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


    public void saveCity(City city) {
        cityRepository.save(city);
    }




}