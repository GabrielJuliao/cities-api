package com.gabrieljuliao.citiesapi.repository;

import com.gabrieljuliao.citiesapi.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
}
