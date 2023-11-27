package com.project.worldwise;

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

    @PostMapping("city-details")
    public String saveCityDetails(@RequestBody List<City> cities) {
        System.out.println("city list: " + cities);

        for (City city : cities) {
            System.out.println(city.getCityName()+" "+ city.getCityPopulation());
            countryService.saveCity(city);
        }
        return "City Details Inserted";
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

    //  @GetMapping("countries/category/{category}")
    // public List<Country> getCountriesByCategory(@PathVariable String countryName) {
    // Validate countryName if needed
    // return countryService.getCountriesByCategory(countryName);
    // }
    @GetMapping("countries/{population}")
    public List<CountryDTO> getCountriesWithPopulation(@PathVariable int population) {
        return new MapToPopulation.MappingStatic().getCountriesWithPopulation(population);
      // return countryService.getCountriesWithPopulation(population);

    }


}


