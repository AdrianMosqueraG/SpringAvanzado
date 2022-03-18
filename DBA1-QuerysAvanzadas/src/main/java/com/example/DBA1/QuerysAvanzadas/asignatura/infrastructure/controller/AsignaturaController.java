package com.example.DBA1.QuerysAvanzadas.asignatura.infrastructure.controller;

import com.example.DBA1.QuerysAvanzadas.asignatura.application.service.interfaz.AsignaturaService;
import com.example.DBA1.QuerysAvanzadas.asignatura.domain.dto.output.AsignaturaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping("/getId/{id}")
    public AsignaturaOutputDto getId(@PathVariable int id) throws Exception{
        return asignaturaService.buscarPorId(id);
    }

    @GetMapping("/getUser/{name}")
    public List<AsignaturaOutputDto> getName(@PathVariable String name){
        return asignaturaService.buscarPorNombre(name);
    }
}
