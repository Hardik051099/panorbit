package com.example.panorbit.service;
import com.example.panorbit.model.Country;
/**
 * Interface for country details service.
 */
public interface CountryDetailsService {

    /**
     * Retrieves country details for a given country code.
     *
     * @param countryCode the country code (ISO 3166-1 alpha-2) for which details are to be retrieved
     * @return the Country object containing the country details
     */
    Country getCountryDetails(String countryCode);
}


