package com.example.panorbit.controller;

import com.example.panorbit.dto.SearchDTO;
import com.example.panorbit.model.Country;
import com.example.panorbit.service.CountryDetailsService;
import com.example.panorbit.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pan")
public class WorldController {
    @Autowired
    private SearchService searchService;
    @Autowired
    private CountryDetailsService countryDetailsService;

    // Other endpoints

    @GetMapping("/search")
    public List<SearchDTO> search(@RequestParam("q") String searchTerm) {
        return searchService.search(searchTerm);
    }
    @GetMapping("/country/{countryCode}")
    public Country getCountryDetails(@PathVariable("countryCode") String countryCode) {
        return countryDetailsService.getCountryDetails(countryCode);
    }


}

