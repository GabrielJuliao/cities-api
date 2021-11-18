package com.gabrieljuliao.citiesapi.modelassemblers;

import com.gabrieljuliao.citiesapi.controllers.CityController;
import com.gabrieljuliao.citiesapi.model.City;
import com.gabrieljuliao.citiesapi.resources.CityResource;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CityModelAssembler implements RepresentationModelAssembler<City, CityResource> {
    @Override
    public CityResource toModel(City entity) {
        return new CityResource(entity)
                .add(linkTo(methodOn(CityController.class).getCityById(entity.getId())).withSelfRel());
    }

    @Override
    public CollectionModel<CityResource> toCollectionModel(Iterable<? extends City> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities)
                .add(linkTo(methodOn(CityController.class).getCities(Pageable.unpaged())).withRel("cities"));
    }
}
