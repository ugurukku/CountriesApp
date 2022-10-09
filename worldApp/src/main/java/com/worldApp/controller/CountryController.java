package com.worldApp.controller;

import com.worldApp.dto.CountryDTO;
import com.worldApp.dto.CountryDTOForMain;
import com.worldApp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(path = "/countries")
    public ResponseEntity<List<CountryDTOForMain>> returnCountries() {

        List<CountryDTOForMain> countriesDTO = new ArrayList<>();
        countryService.getCountries()
                .forEach(country -> countriesDTO.add(new CountryDTOForMain(country)));

        return ResponseEntity.ok(countriesDTO);
    }


    @GetMapping(path = "/countries/{countryName}")
    public ResponseEntity<CountryDTO> returnCountry(@PathVariable("countryName") String countryName) {

        final CountryDTO[] dto = new CountryDTO[1];
        countryService.getCountries().forEach(country -> {
            if (country.getName().matches(countryName)) {
                dto[0] = new CountryDTO(country);
            }

        });
        return ResponseEntity.ok(dto[0]);
    }

}
