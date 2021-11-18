package com.gabrieljuliao.citiesapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "cidade")
@NoArgsConstructor
@AllArgsConstructor
@TypeDefs(value = {
        @TypeDef(name = "point", typeClass = PointType.class)
})
public class City implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "ibge")
    private int ibge;
    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;
    @Column(name = "cod_tom")
    private short cod_tom;
}
