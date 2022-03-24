package com.example.DBA2.Mongo.persona.infrastructure.controller;

import com.example.DBA2.Mongo.persona.application.service.interfaces.PersonaService;
import com.example.DBA2.Mongo.persona.domain.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/getAllPag/{pageNumber}/{pageSize}")
    public List<Persona> getAllPaginated(@PathVariable int pageNumber, @PathVariable int pageSize){
        return personaService.getAllPersonaPaginated(pageNumber, pageSize);
    }

    @GetMapping("/getOneName/{name}")
    public Persona getOneName(@PathVariable String name){
        return personaService.findOneByName(name);
    }

    @GetMapping("/getName/{name}")
    public List<Persona> getName(@PathVariable String name){
        return personaService.findByName(name);
    }

}
