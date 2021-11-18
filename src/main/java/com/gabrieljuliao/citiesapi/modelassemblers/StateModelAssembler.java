package com.gabrieljuliao.citiesapi.modelassemblers;

import com.gabrieljuliao.citiesapi.controllers.StateController;
import com.gabrieljuliao.citiesapi.model.State;
import com.gabrieljuliao.citiesapi.resources.StateResource;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class StateModelAssembler implements RepresentationModelAssembler<State, StateResource> {
    @Override
    public StateResource toModel(State entity) {
        return new StateResource(entity)
                .add(linkTo(methodOn(StateController.class).getStateById(entity.getId())).withSelfRel());
    }

    @Override
    public CollectionModel<StateResource> toCollectionModel(Iterable<? extends State> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities)
                .add(linkTo(methodOn(StateController.class).getStates(Pageable.unpaged())).withRel("states"));
    }
}
