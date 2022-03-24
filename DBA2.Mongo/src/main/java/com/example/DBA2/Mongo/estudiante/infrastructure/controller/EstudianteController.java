package com.example.DBA2.Mongo.estudiante.infrastructure.controller;

import com.example.DBA2.Mongo.estudiante.application.service.interfaces.EstudianteService;
import com.example.DBA2.Mongo.estudiante.domain.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/getAllPag/{pageNumber}/{pageSize}")
    public List<Estudiante> getAllPaginated(@PathVariable int pageNumber, @PathVariable int pageSize){
        return estudianteService.getAllEstudiantePaginated(pageNumber, pageSize);
    }

    @GetMapping("/getOneName/{name}")
    public Estudiante getOneName(@PathVariable String name){
        return estudianteService.findOneByName(name);
    }

    @GetMapping("/getName/{name}")
    public List<Estudiante> getName(@PathVariable String name){
        return estudianteService.findByName(name);
    }
}
