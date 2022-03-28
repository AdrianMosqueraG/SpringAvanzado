package com.example.SA2.SubirBajarFicheros.repository;

import com.example.SA2.SubirBajarFicheros.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, String>, JpaSpecificationExecutor<Country> {

    //List<Country> findAllCountries();


}
