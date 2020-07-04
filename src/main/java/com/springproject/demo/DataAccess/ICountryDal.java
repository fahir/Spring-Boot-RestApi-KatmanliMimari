package com.springproject.demo.DataAccess;

import com.springproject.demo.Entities.City;
import com.springproject.demo.Entities.Country;

import java.util.List;

public interface ICountryDal {
    List<Country> getAll();
    Country add(Country country);
    void update(Country country);
    void delete(Country country);
    Country getById(String id);
}
