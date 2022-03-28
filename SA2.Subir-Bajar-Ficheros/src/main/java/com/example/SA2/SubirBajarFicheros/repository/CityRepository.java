package com.example.SA2.SubirBajarFicheros.repository;

import com.example.SA2.SubirBajarFicheros.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

    List<City> findAllByCountryCode(String code);
}
