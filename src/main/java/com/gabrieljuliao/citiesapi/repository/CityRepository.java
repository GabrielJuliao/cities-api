package com.gabrieljuliao.citiesapi.repository;

import com.gabrieljuliao.citiesapi.model.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    @Query(value = "select ((select lat_lon from cidade where id = :cityId1) <@> (select lat_lon from cidade where id= :cityId2)) as distance", nativeQuery = true)
    Double distanceByPoints(Long cityId1, Long cityId2);
}
