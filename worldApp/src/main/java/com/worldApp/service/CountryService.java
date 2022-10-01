package com.worldApp.service;

import com.worldApp.entity.Country;
import com.worldApp.network.APIConnectionInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountriesDaoInter countriesDAO;

    @Autowired
    public CountryService(@Qualifier("countriesDaoImpl") CountriesDaoInter countriesDAO) {
        this.countriesDAO = countriesDAO;
    }

    public List<Country> getCountries(){
        return countriesDAO.getCountries();
    }

}
