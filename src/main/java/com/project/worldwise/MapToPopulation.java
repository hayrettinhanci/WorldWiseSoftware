package com.project.worldwise;

import java.util.ArrayList;
import java.util.List;

public class MapToPopulation {

    static class MappingStatic {
        CountryRepository countryRepository;
        public List<CountryDTO> getCountriesWithPopulation(int population) {
            List<Country> countries = countryRepository.findAll();
            List<CountryDTO> countryDTOS = new ArrayList<>();
            for (Country country : countries) {
                CountryDTO countryDTO = convertToCountryPopulationDTO(country);
                if (countryDTO.getPopulation() > population) {
                    countryDTOS.add(countryDTO);
                }

            }
            return countryDTOS;

        }

        public CountryDTO convertToCountryPopulationDTO(Country country) {
            CountryDTO countryDTO = new CountryDTO();

            countryDTO.setCountryName(country.getCountryName());
            countryDTO.setPopulation(country.getPopulation());
            return countryDTO;

        }



    }
}
