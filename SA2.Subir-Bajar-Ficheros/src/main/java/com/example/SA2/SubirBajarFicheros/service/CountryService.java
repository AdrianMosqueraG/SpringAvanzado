package com.example.SA2.SubirBajarFicheros.service;

import com.example.SA2.SubirBajarFicheros.domain.Country;
import com.example.SA2.SubirBajarFicheros.exception.CountryNotFoundException;
import com.example.SA2.SubirBajarFicheros.repository.CountryRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends BaseService<Country, String, CountryRepository>{

    @Autowired
    CountryRepository countryRepository;

    public Page<Country> getCountries(Pageable pageable, @SearchSpec
            Specification<Country> specs){
        return countryRepository.findAll(specs, pageable);
    }

    public Country modifyCountry(String id, Country newCountry) {
        Country country = countryRepository.findById(id).orElseThrow(()->new CountryNotFoundException(id));
        newCountry.setCode(country.getCode());
        return countryRepository.save(newCountry);
    }

}
