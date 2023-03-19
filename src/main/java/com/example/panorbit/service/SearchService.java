package com.example.panorbit.service;

import com.example.panorbit.dto.SearchDTO;

import java.util.List;

public interface SearchService {
    List<SearchDTO> search(String searchTerm);
}
