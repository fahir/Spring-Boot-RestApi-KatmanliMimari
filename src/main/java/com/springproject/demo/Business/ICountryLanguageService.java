package com.springproject.demo.Business;

import com.springproject.demo.Entities.Country;
import com.springproject.demo.Entities.Countrylanguage;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICountryLanguageService {
    List<Countrylanguage> getAll();
    Countrylanguage getById(String Id);
    Countrylanguage add(Countrylanguage country);
    void update (Countrylanguage country);
    void delete (Countrylanguage country);
}
