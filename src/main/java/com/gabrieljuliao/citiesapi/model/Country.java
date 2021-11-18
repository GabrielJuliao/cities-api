package com.gabrieljuliao.citiesapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "pais")
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "nome_pt")
    private String namePtBr;
    @Column(name = "sigla")
    private char[] abbrev;
    @Column(name = "bacen")
    private int bacen;
}
