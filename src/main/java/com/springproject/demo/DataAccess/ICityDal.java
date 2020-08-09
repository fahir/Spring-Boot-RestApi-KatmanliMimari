package com.springproject.demo.DataAccess;

import com.springproject.demo.Entities.City;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface ICityDal extends QuerydslPredicateExecutor<City> {
    List<City> getAll();

    City add(City city);

    void update(City city);

    void delete(City city);

    City getById(int id);

}
