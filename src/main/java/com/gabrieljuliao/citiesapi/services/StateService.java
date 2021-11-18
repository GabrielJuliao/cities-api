package com.gabrieljuliao.citiesapi.services;

import com.gabrieljuliao.citiesapi.exceptions.ResourceNotFoundException;
import com.gabrieljuliao.citiesapi.model.State;
import com.gabrieljuliao.citiesapi.modelassemblers.StateModelAssembler;
import com.gabrieljuliao.citiesapi.repository.StateRepository;
import com.gabrieljuliao.citiesapi.resources.StateResource;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StateService {
    private final StateRepository stateRepository;
    private final StateModelAssembler stateModelAssembler;

    public StateService(StateRepository stateRepository, StateModelAssembler stateModelAssembler) {
        this.stateRepository = stateRepository;
        this.stateModelAssembler = stateModelAssembler;
    }
    public CollectionModel<StateResource> getStates(Pageable pageable) {
        return stateModelAssembler.toCollectionModel(stateRepository.findAll(pageable));
    }

    public StateResource getById(Long id) {
        Optional<State> state = stateRepository.findById(id);
        if (state.isPresent()) {
            return stateModelAssembler.toModel(state.get());
        }
        throw new ResourceNotFoundException();
    }
}
