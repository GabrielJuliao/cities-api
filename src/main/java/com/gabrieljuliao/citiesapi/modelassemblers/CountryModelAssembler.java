package com.gabrieljuliao.citiesapi.modelassemblers;

import com.gabrieljuliao.citiesapi.controllers.CountryController;
import com.gabrieljuliao.citiesapi.model.Country;
import com.gabrieljuliao.citiesapi.resources.CountryResource;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CountryModelAssembler implements RepresentationModelAssembler<Country, CountryResource> {

    @Override
    public CountryResource toModel(Country entity) {
        return new CountryResource(entity)
                .add(linkTo(methodOn(CountryController.class).getCountryById(entity.getId())).withSelfRel());
    }

    @Override
    public CollectionModel<CountryResource> toCollectionModel(Iterable<? extends Country> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities)
                .add(linkTo(methodOn(CountryController.class).getCountries(Pageable.unpaged())).withRel("countries"));
    }
}
