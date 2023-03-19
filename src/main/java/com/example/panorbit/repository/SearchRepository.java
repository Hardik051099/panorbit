package com.example.panorbit.repository;

import com.example.panorbit.dto.SearchDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SearchRepository extends JpaRepository<SearchDTO, Long> {
    @Query(value = "SELECT c.ID as id, c.Name as name, 'city' as type FROM city c WHERE c.Name LIKE %:searchTerm% " +
            "UNION " +
            "SELECT co.Code as id, co.Name as name, 'country' as type FROM country co WHERE co.Name LIKE %:searchTerm% " +
            "UNION " +
            "SELECT cl.ID as id, cl.Language as name, 'language' as type FROM countrylanguage cl WHERE cl.Language LIKE %:searchTerm%",
            nativeQuery = true)
    List<SearchDTO> search(@Param("searchTerm") String searchTerm);
}
