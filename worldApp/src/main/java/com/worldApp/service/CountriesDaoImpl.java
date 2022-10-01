package com.worldApp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.worldApp.entity.Country;
import com.worldApp.network.APIConnectionInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CountriesDaoImpl implements CountriesDaoInter {


    private final APIConnectionInter connection;

    @Autowired
    public CountriesDaoImpl(@Qualifier(value = "connectionAPI")APIConnectionInter connection) {
        this.connection = connection;
    }

    @Override
    public List<Country> getCountries() {
        ObjectMapper mapper = new ObjectMapper();
        Country[] countries;

        try {
           countries = mapper.readValue(connection.getInformationString(),Country[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return Arrays.asList(countries);
    }
}
