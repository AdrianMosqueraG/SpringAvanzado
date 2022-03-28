package com.example.SA2.SubirBajarFicheros.controller;

import com.example.SA2.SubirBajarFicheros.domain.City;
import com.example.SA2.SubirBajarFicheros.exception.CityNotFoundException;
import com.example.SA2.SubirBajarFicheros.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/ciudades")
    public ResponseEntity<List<City>> listaCiudades(@RequestParam(value = "pais",
            defaultValue = "") String pais) {
        List<City> ciudades = null;
        if (pais.equals(""))
            ciudades = cityService.findAllByCountryCode("ESP");
        else
            ciudades = cityService.findAllByCountryCode(pais);
        return new ResponseEntity<>(ciudades, HttpStatus.OK);
    }

    @GetMapping("/ciudades/{id}")
    public ResponseEntity<City> findById(@PathVariable Integer id) {
        City city = cityService.findById(id).orElseThrow(() -> new
                CityNotFoundException(id));
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PostMapping(path = "/addCiudad")
    public ResponseEntity<City> addCity(@RequestBody City city) {
        City addedCity = cityService.save(city);
        return new ResponseEntity<>(addedCity, HttpStatus.OK);
    }

    @PutMapping("/modCiudad/{id}")
    public ResponseEntity<City> modifyCity(@PathVariable Integer id, @RequestBody City
            newCity) {
        City addedCity = cityService.modifyCity(id, newCity);
        return new ResponseEntity<>(addedCity, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCiudad/{id}")
    public ResponseEntity<Response> deleteCity(@PathVariable Integer id) {
        City c = cityService.findById(id).orElseThrow(() -> new CityNotFoundException(id));
        cityService.delete(c);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }

    @ExceptionHandler(CityNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response> handleException(CityNotFoundException pnfe) {
        Response response = Response.errorResponse(Response.NOT_FOUND, pnfe.getMessage());
        return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
    }
}
