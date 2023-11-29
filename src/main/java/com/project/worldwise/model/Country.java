package com.project.worldwise.model;

import com.project.worldwise.model.City;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
public class Country {
    @Id
    Long id;
    String countryName;
    int population;
    int numberOfCities;
    int temperature;
    String briefInformation;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id",referencedColumnName = "id")
   // @OneToMany(mappedBy = "country",cascade = CascadeType.ALL)
    private List<City> cities;

    public void setId(long id) {
        this.id = id;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    public void setNumberOfCities(int numberOfCities) {
        this.numberOfCities = numberOfCities;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    public void setBriefInformation(String briefInformation) {
        this.briefInformation = briefInformation;
    }
}
