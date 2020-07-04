package com.springproject.demo.Business;

import com.springproject.demo.DataAccess.ICountryDal;
import com.springproject.demo.Entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CountryManager implements ICountryService {
    private ICountryDal _countryDal;
    @Autowired
    public CountryManager(ICountryDal countryDal) {
        _countryDal = countryDal;
    }

    @Override
    @Transactional
    public List<Country> getAll() {
        return _countryDal.getAll();
    }

    @Override
    @Transactional
    public Country getById(String Id) {
        return _countryDal.getById(Id);
    }

    @Override
    @Transactional
    public Country add(Country country) {
        return _countryDal.add(country);
    }

    @Override
    @Transactional
    public void update(Country country) {
_countryDal.update(country);
    }

    @Override
    public void delete(Country country) {
_countryDal.delete(country);
    }
}
