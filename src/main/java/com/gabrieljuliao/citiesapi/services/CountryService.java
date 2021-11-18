package com.gabrieljuliao.citiesapi.services;

import com.gabrieljuliao.citiesapi.modelassemblers.CountryModelAssembler;
import com.gabrieljuliao.citiesapi.exceptions.ResourceNotFoundException;
import com.gabrieljuliao.citiesapi.model.Country;
import com.gabrieljuliao.citiesapi.repository.CountryRepository;
import com.gabrieljuliao.citiesapi.resources.CountryResource;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;
    private final CountryModelAssembler countryModelAssembler;

    public CountryService(CountryRepository countryRepository, CountryModelAssembler countryModelAssembler) {
        this.countryRepository = countryRepository;
        this.countryModelAssembler = countryModelAssembler;
    }

    public CollectionModel<CountryResource> getCountries(Pageable pageable) {
        return countryModelAssembler.toCollectionModel(countryRepository.findAll(pageable));
    }

    public CountryResource getById(Long id) {
        Optional<Country> country = countryRepository.findById(id);
        if (country.isPresent()) {
            return countryModelAssembler.toModel(country.get());
        }
        throw new ResourceNotFoundException();
    }
}
