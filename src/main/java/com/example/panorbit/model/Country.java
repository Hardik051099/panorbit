package com.example.panorbit.model;

import com.example.panorbit.enums.Continent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "country")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @Column(name = "Code", nullable = false)
    private String code;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Continent", nullable = false)
    @Enumerated(EnumType.STRING)
    private Continent continent;

    @Column(name = "Region", nullable = false)
    private String region;

    @Column(name = "SurfaceArea", nullable = false)
    private Float surfaceArea;

    @Column(name = "IndepYear")
    private Integer indepYear;

    @Column(name = "Population", nullable = false)
    private Integer population;

    @Column(name = "LifeExpectancy")
    private Float lifeExpectancy;

    @Column(name = "GNP")
    private Float gnp;

    @Column(name = "GNPOld")
    private Float gnpOld;

    @Column(name = "LocalName", nullable = false)
    private String localName;

    @Column(name = "GovernmentForm", nullable = false)
    private String governmentForm;

    @Column(name = "HeadOfState")
    private String headOfState;

    @Column(name = "Capital")
    private Integer capital;

    @Column(name = "Code2", nullable = false)
    private String code2;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<City> cities = new HashSet<>();

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<CountryLanguage> languages = new HashSet<>();

}

