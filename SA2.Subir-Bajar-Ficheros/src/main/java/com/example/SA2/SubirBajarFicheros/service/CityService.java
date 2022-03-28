package com.example.SA2.SubirBajarFicheros.service;

import com.example.SA2.SubirBajarFicheros.domain.City;
import com.example.SA2.SubirBajarFicheros.exception.CityNotFoundException;
import com.example.SA2.SubirBajarFicheros.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService extends BaseService<City, Integer, CityRepository> {

    @Autowired
    CityRepository cityRepository;

    public Boolean existeCiudad(Integer code){
        if(cityRepository.existsById(code)) return true;
        return false;
    }

    public List<City> findAllByCountryCode(String pais){
        return cityRepository.findAllByCountryCode(pais);
    }

    public City modifyCity(Integer id, City newCity) {
        City city= cityRepository.findById(id).orElseThrow(()-> new
                CityNotFoundException(id));
        newCity.setId(city.getId());
        return cityRepository.save(newCity);
    }
}
