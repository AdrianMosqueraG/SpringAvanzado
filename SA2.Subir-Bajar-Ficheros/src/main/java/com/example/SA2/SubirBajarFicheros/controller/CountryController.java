package com.example.SA2.SubirBajarFicheros.controller;

import com.example.SA2.SubirBajarFicheros.domain.Country;
import com.example.SA2.SubirBajarFicheros.exception.CountryNotFoundException;
import com.example.SA2.SubirBajarFicheros.service.CountryService;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/paises")
    public ResponseEntity<Page<Country>> listaPaises(@PageableDefault(size = 5, page = 0) Pageable pageable,
                                                     @SearchSpec Specification<Country> specs) throws Exception{
        Page<Country> paises;
        paises = countryService.getCountries(pageable,specs);

        return new ResponseEntity<>(paises, HttpStatus.OK);
    }

    @GetMapping("/paises/{id}")
    public ResponseEntity<Country> getPais(@PathVariable String id){
        Country c = countryService.findById(id).orElseThrow(() -> new
                CountryNotFoundException(id));
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PostMapping("/addPais")
    public ResponseEntity<Country> addCountry(@RequestBody Country c){
        Country addedCountry = countryService.save(c);
        return new ResponseEntity<>(addedCountry,HttpStatus.OK);
    }

    @PutMapping("/modCountry/{id}")
    public ResponseEntity<Country> modifyCountry(@PathVariable String id, @RequestBody Country newCountry){
        Country addedCountry = countryService.modifyCountry(id, newCountry);
        return new ResponseEntity<>(addedCountry,HttpStatus.OK);
    }

    @DeleteMapping("/deleteCountry/{id}")
    public ResponseEntity<Response> deleteCountry(@PathVariable String id){
        Country c = countryService.findById(id).orElseThrow(() -> new CountryNotFoundException(id));
        countryService.delete(c);

        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }

    @ExceptionHandler(CountryNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response> handleException(CountryNotFoundException pnfe) {
        Response response = Response.errorResponse(Response.NOT_FOUND, pnfe.getMessage());
        return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
}}

