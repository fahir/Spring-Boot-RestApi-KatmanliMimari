package com.springproject.demo.Business;

import com.springproject.demo.DataAccess.ICountrylanguageDal;
import com.springproject.demo.Entities.Countrylanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryLanguageManager implements ICountryLanguageService {

private  ICountrylanguageDal _countrylanguageDal;
@Autowired
    public CountryLanguageManager(ICountrylanguageDal countrylanguageDal) {
        _countrylanguageDal = countrylanguageDal;
    }

    @Override
    @Transactional
    public List<Countrylanguage> getAll() {

        return _countrylanguageDal.getAll();
    }

    @Override
    @Transactional
    public Countrylanguage getById(String Id) {
        return _countrylanguageDal.getById(Id);
    }

    @Override
    @Transactional
    public Countrylanguage add(Countrylanguage country) {
        return _countrylanguageDal.add(country);
    }

    @Override
    @Transactional
    public void update(Countrylanguage country) {
_countrylanguageDal.update(country);
    }

    @Override
    @Transactional
    public void delete(Countrylanguage country) {
_countrylanguageDal.delete(country);
    }
}
