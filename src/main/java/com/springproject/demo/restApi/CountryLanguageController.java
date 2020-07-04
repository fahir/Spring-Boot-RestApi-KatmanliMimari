package com.springproject.demo.restApi;

import com.springproject.demo.Business.ICountryLanguageService;
import com.springproject.demo.Entities.Countrylanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countryLanguageCodes")
public class CountryLanguageController {
    private ICountryLanguageService _countryLanguageService;

    @Autowired
    public CountryLanguageController(ICountryLanguageService countryLanguageService) {
        _countryLanguageService = countryLanguageService;
    }

    @GetMapping()
    public List<Countrylanguage> get() {
        return _countryLanguageService.getAll();
    }

    @GetMapping("/{id}")
    public Countrylanguage getById(@PathVariable String id) {
        return _countryLanguageService.getById(id);
    }

    @PostMapping("/add")
    public Countrylanguage add(@RequestBody Countrylanguage countrylanguage) {
        return _countryLanguageService.add(countrylanguage);
    }

    @PostMapping("/update")
    public void update(@RequestBody Countrylanguage countrylanguage) {
        _countryLanguageService.update(countrylanguage);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Countrylanguage countrylanguage) {
        _countryLanguageService.delete(countrylanguage);
    }
}
