package com.springproject.demo.DataAccess;

import com.springproject.demo.Entities.Country;
import com.springproject.demo.Entities.Countrylanguage;

import java.util.List;

public interface ICountrylanguageDal {
    List<Countrylanguage> getAll();
    Countrylanguage add(Countrylanguage country);
    void update(Countrylanguage country);
    void delete(Countrylanguage country);
    Countrylanguage getById(String id);
}
