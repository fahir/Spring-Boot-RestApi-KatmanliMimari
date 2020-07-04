package com.springproject.demo.Business;

import com.springproject.demo.Entities.Country;

import java.util.List;

public interface ICountryService {
    List<Country> getAll();
    Country getById(String Id);
    Country add(Country country);
    void update (Country country);
    void delete (Country country);
}
