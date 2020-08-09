package com.springproject.demo.Business;

import com.springproject.demo.Entities.City;

import javax.sql.rowset.Predicate;
import java.util.List;
import java.util.Optional;

public interface ICityService {
    List<City> getAll();

    City getById(int id);

    City add(City city);

    void update(City city);

    void delete(City city);


    Iterable<City> findAll(String columnName, String value, String orderColumn);

    Optional<City> findOne(Predicate predicate);

    List<City> getByCountryCodeLike(String countryCode);
    //List<City> getByNameOrCountryCode(String type);
}
