package com.springproject.demo.restApi;

import com.springproject.demo.Business.ICityService;
import com.springproject.demo.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {
private ICityService cityService;

    @Autowired
    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping()
    public List<City> get(){
    return cityService.getAll();
    }
    @PostMapping("/add")
    public City add(@RequestBody City city){

    return  cityService.add(city);
    }
    @PostMapping("/update")
    public void update(@RequestBody City city){
        cityService.update(city);
    }
    @PostMapping("/delete")
    public void delete(@RequestBody City city){
        cityService.delete(city);
    }
    @GetMapping("/{id}")
    public  City getById(@PathVariable int id){
        return cityService.getById(id);
    }
}
