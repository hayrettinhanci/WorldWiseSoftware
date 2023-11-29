package com.project.worldwise.repository;

import com.project.worldwise.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

   Optional<Country> findById(Long id);

   void deleteById(Long id);
}