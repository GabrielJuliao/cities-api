package com.gabrieljuliao.citiesapi.resources;

import com.gabrieljuliao.citiesapi.controllers.CityController;
import com.gabrieljuliao.citiesapi.controllers.CountryController;
import com.gabrieljuliao.citiesapi.controllers.StateController;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class HomeResource extends RepresentationModel<HomeResource> {
    public HomeResource() {
        this.add(linkTo(methodOn(CountryController.class).getCountries(Pageable.unpaged())).withRel("countries"));
        this.add(linkTo(methodOn(StateController.class).getStates(Pageable.unpaged())).withRel("states"));
        this.add(linkTo(methodOn(CityController.class).getCities(Pageable.unpaged())).withRel("cities"));
    }
}
