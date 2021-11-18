package com.gabrieljuliao.citiesapi.controllers;

import com.gabrieljuliao.citiesapi.services.CityService;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Locale;

@RestController
@RequestMapping(value = "/city", produces = {MediaTypes.HAL_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<?> getCities(Pageable pageable) {
        return new ResponseEntity<>(
                cityService.getCities(pageable),
                HttpStatus.OK
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCityById(@PathVariable Long id) {
        return new ResponseEntity<>(
                cityService.getById(id),
                HttpStatus.OK);
    }

    @GetMapping(value = "/distance-in-between/{cityId1}/{cityId2}")
    public ResponseEntity<?> distanceInBetweenIn(@PathVariable Long cityId1, @PathVariable Long cityId2, @PathParam("unit") String unit) {
        if (unit != null){
            unit = unit.toUpperCase(Locale.ROOT);
        }
        return new ResponseEntity<>(cityService.distanceByPoints(cityId1, cityId2, unit), HttpStatus.OK);
    }
}
