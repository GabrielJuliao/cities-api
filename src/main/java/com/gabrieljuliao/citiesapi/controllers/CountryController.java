package com.gabrieljuliao.citiesapi.controllers;

import com.gabrieljuliao.citiesapi.services.CountryService;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/country", produces = {MediaTypes.HAL_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<?> getCountries(Pageable pageable) {
        return new ResponseEntity<>(
                countryService.getCountries(pageable),
                HttpStatus.OK
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCountryById(@PathVariable Long id) {
        return new ResponseEntity<>(
                countryService.getById(id),
                HttpStatus.OK);
    }
}
