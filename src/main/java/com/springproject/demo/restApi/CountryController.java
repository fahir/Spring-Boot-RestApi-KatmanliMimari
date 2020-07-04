package com.springproject.demo.restApi;

import com.springproject.demo.Business.ICountryService;
import com.springproject.demo.Entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    private ICountryService _countryService;
@Autowired
    public CountryController(ICountryService _countryService) {
        this._countryService = _countryService;
    }

    @GetMapping()
    public List<Country> get(){
        return _countryService.getAll();
    }
    @PostMapping("/add")
    public  Country add(@RequestBody Country country){ return  _countryService.add(country);}
    @PostMapping("/update")
    public void update(@RequestBody Country country){   _countryService.update(country);}
    @GetMapping("/delete")
    public  void delete(@RequestBody Country country){   _countryService.delete(country);}
    @GetMapping("/{id}")
    public  Country getById (@PathVariable String id ){  return _countryService.getById(id);}

}
