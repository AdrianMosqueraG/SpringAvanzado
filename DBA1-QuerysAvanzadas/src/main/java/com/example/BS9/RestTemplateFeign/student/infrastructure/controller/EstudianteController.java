package com.example.BS9.RestTemplateFeign.student.infrastructure.controller;

import com.example.BS9.RestTemplateFeign.student.application.service.interfaz.EstudianteService;
import com.example.BS9.RestTemplateFeign.student.domain.dto.output.EstudianteOutputDto;
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

    @GetMapping("/getId/{id}")
    public EstudianteOutputDto getId(@PathVariable int id) throws Exception{
        return estudianteService.buscarPorId(id);
    }

    @GetMapping("/getName/{name}")
    public List<EstudianteOutputDto> getName(@PathVariable String name){
        return estudianteService.buscarPorName(name);
    }
}
