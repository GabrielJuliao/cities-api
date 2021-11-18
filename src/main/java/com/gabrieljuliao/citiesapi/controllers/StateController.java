package com.gabrieljuliao.citiesapi.controllers;

import com.gabrieljuliao.citiesapi.services.StateService;
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
@RequestMapping(value = "/state", produces = {MediaTypes.HAL_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    public ResponseEntity<?> getStates(Pageable pageable) {
        return new ResponseEntity<>(
                stateService.getStates(pageable),
                HttpStatus.OK
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getStateById(@PathVariable Long id) {
        return new ResponseEntity<>(
                stateService.getById(id),
                HttpStatus.OK);
    }
}
