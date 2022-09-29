package com.worldApp.service;

import com.worldApp.entity.Country;
import com.worldApp.network.APIConnectionInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final APIConnectionInter apiConnectionInter;

    @Autowired
    public CountryService(@Qualifier("countryRepo") APIConnectionInter apiConnectionInter) {
        this.apiConnectionInter = apiConnectionInter;
    }

    public List<Country> getCountries(){
        return apiConnectionInter.getCountries();
    }

}
