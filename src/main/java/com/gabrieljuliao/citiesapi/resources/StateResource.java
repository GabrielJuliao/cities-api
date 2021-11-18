package com.gabrieljuliao.citiesapi.resources;

import com.gabrieljuliao.citiesapi.model.State;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Relation(collectionRelation = "states")
public class StateResource extends RepresentationModel<StateResource> {
    private Long id;
    private String name;
    private char[] abbrev;
    private int ibge;
    private CountryResource country;
    private List<Integer> areaCodes;

    public StateResource(State state){
        this.id = state.getId();
        this.name = state.getName();
        this.abbrev = state.getAbbrev();
        this.ibge = state.getIbge();
        this.country = new CountryResource(state.getCountry());
        this.areaCodes = state.getAreaCodes();
    }
}
