package com.dj.controller;

import com.dj.model.Country;
import com.dj.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by DJ on 11/23/16.
 */
@RestController
@RequestMapping(value = "countries")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    @RequestMapping(value = "{countryCode}", method = RequestMethod.GET)
    public String getCountryByCode(@PathVariable(value = "countryCode") String code, Model model) {
        Country country = countryRepository.findByCode(code);
        model.addAttribute("country", country);
        return "countries/country";
    }

    @RequestMapping(value = "/{countryName}", method = RequestMethod.GET, produces = "text/html")
    public String getCountryByName(@PathVariable(value = "countryName") String name, Model model) {
        Country country = countryRepository.findByName(name);
        model.addAttribute("country", country);
        return country.getCode();
    }
}
