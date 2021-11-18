package com.gabrieljuliao.citiesapi.repository;

import com.gabrieljuliao.citiesapi.model.State;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StateRepository extends PagingAndSortingRepository<State, Long> {
}
