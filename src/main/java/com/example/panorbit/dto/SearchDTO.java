package com.example.panorbit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SearchDTO {
    @Id
    private Long id;
    private String name;
    private String type; // "city", "country", or "language"

}



