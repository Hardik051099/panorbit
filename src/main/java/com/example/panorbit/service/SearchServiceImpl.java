package com.example.panorbit.service;

import com.example.panorbit.dto.SearchDTO;
import com.example.panorbit.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{
    @Autowired
    private SearchRepository searchRepository;

    @Override
    public List<SearchDTO> search(String searchTerm) {
        return searchRepository.search(searchTerm);
    }
}
