package com.example.DBA2.Mongo.estudiante.infrastructure.controller;

import com.example.DBA2.Mongo.estudiante.application.service.interfaces.EstudianteCrudService;
import com.example.DBA2.Mongo.estudiante.domain.entity.Estudiante;
import com.example.DBA2.Mongo.persona.domain.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteCrudController {

    @Autowired
    private EstudianteCrudService estudianteCrudService;

    @GetMapping("/getAll")
    public List<Estudiante> getAll(){
        return estudianteCrudService.getAllEstudiante();
    }

    @PostMapping("/add")
    public Estudiante addPersona(@RequestBody Estudiante estudiante){
        return estudianteCrudService.saveEstudiante(estudiante);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePersona(@PathVariable String id){
        estudianteCrudService.deleteEstudiante(id);
    }

    @PutMapping("/mod")
    public Estudiante updatePersona(@RequestBody Estudiante estudiante) throws Exception {
        return estudianteCrudService.updateOneEstudiante(estudiante);
    }
}
