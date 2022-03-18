package com.example.BS9.RestTemplateFeign.persona.infrastructure.controller;

import com.example.BS9.RestTemplateFeign.persona.application.service.interfaz.PersonaCrudService;
import com.example.BS9.RestTemplateFeign.persona.domain.dto.input.PersonaInputDto;
import com.example.BS9.RestTemplateFeign.persona.domain.dto.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaCrudController {

    @Autowired
    private PersonaCrudService personaCrudService;

    @GetMapping("/getAll")
    public List<PersonaOutputDto> getAll(){
        return personaCrudService.getAll();
    }

    @PostMapping("/add")
    public PersonaOutputDto addPerson(@RequestBody PersonaInputDto personaInputDto) throws Exception {
        return personaCrudService.addPersona(personaInputDto);
    }

    @DeleteMapping("/delete/{id}")
    public PersonaOutputDto deleteId(@PathVariable int id) throws Exception {
        return personaCrudService.deletePersona(id);
    }

    @PutMapping("/mod/{id}")
    public PersonaOutputDto updateId(@PathVariable int id, @RequestBody PersonaInputDto personaInputDto){
        return personaCrudService.modifyPersona(id, personaInputDto);
    }

}
