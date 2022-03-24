package com.example.DBA2.Mongo.persona.infrastructure.controller;

import com.example.DBA2.Mongo.persona.application.service.interfaces.PersonaCrudService;
import com.example.DBA2.Mongo.persona.domain.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaCrudController {

    @Autowired
    private PersonaCrudService personaCrudService;

    @GetMapping("/getAll")
    public List<Persona> getAll(){
        return personaCrudService.getAllPersona();
    }

    @PostMapping("/add")
    public Persona addPersona(@RequestBody Persona persona){
        return personaCrudService.savePersona(persona);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePersona(@PathVariable String id){
        personaCrudService.deletePersona(id);
    }

    @PutMapping("/mod")
    public Persona updatePersona(@RequestBody Persona persona) throws Exception {
        return personaCrudService.updateOnePersona(persona);
    }

}
