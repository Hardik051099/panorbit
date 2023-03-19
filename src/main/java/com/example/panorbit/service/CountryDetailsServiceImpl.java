package com.example.panorbit.service;

import com.example.panorbit.model.Country;
import com.example.panorbit.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryDetailsServiceImpl implements CountryDetailsService{
    @Autowired
    private CountryRepository countryRepository;

    public Country getCountryDetails(String countryCode) {
        return countryRepository.findById(countryCode).orElse(null);
    }
}
