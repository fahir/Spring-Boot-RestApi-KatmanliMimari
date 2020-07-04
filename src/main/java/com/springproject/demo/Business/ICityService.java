package com.springproject.demo.Business;
import com.springproject.demo.Entities.City;
import java.util.List;

public interface ICityService {
    List<City> getAll();
  City  getById(int id);
    City add(City city);
    void update(City city);
    void delete(City city);
}
