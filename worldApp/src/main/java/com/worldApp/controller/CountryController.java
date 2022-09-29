package com.worldApp.controller;

import com.worldApp.entity.Country;
import com.worldApp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(path = "/olkeler")
    public ResponseEntity<List<Country>> returnCountries() {

        return ResponseEntity.ok(countryService.getCountries());
    }


}
