package com.project.worldwise.dto;

import com.project.worldwise.model.Country;
import java.util.ArrayList;
import java.util.List;

public class MapToPopulation {

        public static List<CountryDTO> getCountriesWithPopulation(List<Country> countries, int population) {

            List<CountryDTO> countryDTOS = new ArrayList<>();
            for (Country country : countries) {
                CountryDTO countryDTO = convertToCountryPopulationDTO(country);
                if (countryDTO.getPopulation() > population) {
                    countryDTOS.add(countryDTO);
                }

            }
            return countryDTOS;

        }

        private static CountryDTO convertToCountryPopulationDTO(Country country) {
            CountryDTO countryDTO = new CountryDTO();

            countryDTO.setCountryName(country.getCountryName());
            countryDTO.setPopulation(country.getPopulation());
            return countryDTO;

        }



    }

