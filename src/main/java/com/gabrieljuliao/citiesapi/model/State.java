package com.gabrieljuliao.citiesapi.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estado")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class State {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "uf")
    private char[] abbrev;
    @Column(name = "ibge")
    private int ibge;
    @ManyToOne
    @JoinColumn(name = "pais")
    private Country country;
    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> areaCodes;
}
