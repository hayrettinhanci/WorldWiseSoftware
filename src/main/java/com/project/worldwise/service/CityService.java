package com.project.worldwise.service;
import com.project.worldwise.model.City;
import com.project.worldwise.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CityService {
    private CityRepository cityRepository;

    public String getCountryNameByCityName(String cityName) {
        City city = cityRepository.findByCityName(cityName);
        if (city != null) {
            return city.getCountry().getCountryName();
        }
        return "Country not found";
    }
    public void saveCity(City city) {
        cityRepository.save(city);
    }



}