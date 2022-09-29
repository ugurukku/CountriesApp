package com.worldApp.dto;

import com.worldApp.entity.Country;

public class CountryDTO {

    private String name;
    private String capital;
    private String region;
    private String currency;
    private String flag;
    private String language;
    private String religion;

    public CountryDTO() {
    }

    public CountryDTO(String name, String capital, String region, String currency, String flag, String language,
                      String religion) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.currency = currency;
        this.flag = flag;
        this.language = language;
        this.religion = religion;
    }

    public CountryDTO(Country country){

        this.name = country.getName();
        this.capital = country.getCapital();
        this.region = country.getRegion();
        this.currency = country.getCurrency();
        this.flag = country.getFlag();
        this.language = country.getLanguage();
        this.religion = country.getReligion();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }
}
