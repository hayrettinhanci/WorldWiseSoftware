package com.project.worldwise;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
public class City {
    @Id
    @GeneratedValue
    Long cityId;
    String cityName;
    int cityPopulation;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
