package com.project.worldwise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;


@Getter
@Setter
public class CountryDTO {

    private String countryName;
    private int population;



}
