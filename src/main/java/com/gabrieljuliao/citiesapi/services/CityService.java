package com.gabrieljuliao.citiesapi.services;

import com.gabrieljuliao.citiesapi.exceptions.ResourceNotFoundException;
import com.gabrieljuliao.citiesapi.model.City;
import com.gabrieljuliao.citiesapi.modelassemblers.CityModelAssembler;
import com.gabrieljuliao.citiesapi.repository.CityRepository;
import com.gabrieljuliao.citiesapi.resources.CityResource;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {
    private final CityRepository cityRepository;
    private final CityModelAssembler cityModelAssembler;

    public CityService(CityRepository cityRepository, CityModelAssembler cityModelAssembler) {
        this.cityRepository = cityRepository;
        this.cityModelAssembler = cityModelAssembler;
    }

    public CollectionModel<CityResource> getCities(Pageable pageable) {
        return cityModelAssembler.toCollectionModel(cityRepository.findAll(pageable));
    }

    public CityResource getById(Long id) {
        Optional<City> city = cityRepository.findById(id);
        if (city.isPresent()) {
            return cityModelAssembler.toModel(city.get());
        }
        throw new ResourceNotFoundException();
    }

    public String distanceByPoints(Long city1, Long city2, String unit) {
        Optional<City> optionalCity1 = cityRepository.findById(city1);
        Optional<City> optionalCity2 = cityRepository.findById(city2);

        if (optionalCity1.isPresent() && optionalCity2.isPresent()) {

            Double distanceInMyles = cityRepository.distanceByPoints(city1, city2);
            if ("MI".equals(unit)) {
                return distanceInMyles + " Miles";
            }
            //distance in km as default
            return distanceInMyles * 1.6 + " Kilometers";
        }
        throw new ResourceNotFoundException();
    }
}
