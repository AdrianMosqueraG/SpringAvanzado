package com.example.BS9.RestTemplateFeign.persona.infrastructure.controller;

import com.example.BS9.RestTemplateFeign.persona.application.service.interfaz.PersonaService;
import com.example.BS9.RestTemplateFeign.persona.domain.dto.output.PersonaOutputDto;
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

    @GetMapping("/getId/{id}")
    public PersonaOutputDto getId(@PathVariable int id) throws Exception{
        return personaService.buscarPorId(id);
    }

    @GetMapping("/getUser/{user}")
    public List<PersonaOutputDto> getUser(@PathVariable String user){
        return personaService.buscarPorUsuario(user);
    }
}
