package com.project.worldwise;
import com.project.worldwise.City;
import com.project.worldwise.Country;
import com.project.worldwise.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
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

}