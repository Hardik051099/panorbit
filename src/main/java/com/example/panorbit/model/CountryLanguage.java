package com.example.panorbit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.panorbit.enums.IsOfficial;

import javax.persistence.*;

@Entity
@Table(name = "countrylanguage")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Language", nullable = false)
    private String language;

    @Column(name = "IsOfficial", nullable = false)
    @Enumerated(EnumType.STRING)
    private IsOfficial isOfficial;

    @Column(name = "Percentage", nullable = false)
    private Float percentage;

    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;
}

