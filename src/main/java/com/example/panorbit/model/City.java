package com.example.panorbit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "District", nullable = false)
    private String district;

    @Column(name = "Population", nullable = false)
    private Integer population;

    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;

}
