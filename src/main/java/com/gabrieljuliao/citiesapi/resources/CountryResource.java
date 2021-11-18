package com.gabrieljuliao.citiesapi.resources;

import com.gabrieljuliao.citiesapi.model.Country;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@EqualsAndHashCode(callSuper = true)
@Data
@Relation(collectionRelation = "countries")
public class CountryResource extends RepresentationModel<CountryResource> {
    private Long id;
    private String name;
    private String namePtBr;
    private char[] abbrev;
    private int bacen;

    public CountryResource(Country country) {
        this.id = country.getId();
        this.name = country.getName();
        this.namePtBr = country.getNamePtBr();
        this.abbrev = country.getAbbrev();
        this.bacen = country.getBacen();
    }

}
