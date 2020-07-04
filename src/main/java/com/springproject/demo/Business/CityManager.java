package com.springproject.demo.Business;

import com.springproject.demo.DataAccess.*;
import com.springproject.demo.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CityManager implements ICityService {
    private ICityDal _cityDal;

    @Autowired
    public CityManager(ICityDal cityDal) {
        this._cityDal = cityDal;
    }

    @Override
    @Transactional
    public List<City> getAll() {

        return _cityDal.getAll();
    }
    @Transactional
    @Override
    public City getById(int id) {
        return _cityDal.getById(id);
    }

    @Override
    @Transactional
    public City add(City city) {
return _cityDal.add(city);
    }

    @Override
    @Transactional
    public void update(City city) {
_cityDal.update(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
_cityDal.update(city);
    }
}
