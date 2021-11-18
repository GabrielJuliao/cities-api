package com.gabrieljuliao.citiesapi.controllers;

import com.gabrieljuliao.citiesapi.resources.HomeResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public ResponseEntity<?> getHome() {
        return new ResponseEntity<>(new HomeResource(), HttpStatus.OK);
    }
}
