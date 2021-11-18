package com.gabrieljuliao.citiesapi.resources;

import com.gabrieljuliao.citiesapi.model.City;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.geo.Point;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@EqualsAndHashCode(callSuper = true)
@Data
@Relation(collectionRelation = "cities")
public class CityResource extends RepresentationModel<CityResource> {
    private Long id;
    private String name;
    private int ibge;
    private Point lat_lon;
    private double latitude;
    private double longitude;
    private short cod_tom;

    public CityResource(City city) {
        this.id = city.getId();
        this.name = city.getName();
        this.ibge = city.getIbge();
        this.lat_lon = city.getLocation();
        this.latitude = city.getLatitude();
        this.longitude = city.getLongitude();
        this.cod_tom = city.getCod_tom();
    }
}
