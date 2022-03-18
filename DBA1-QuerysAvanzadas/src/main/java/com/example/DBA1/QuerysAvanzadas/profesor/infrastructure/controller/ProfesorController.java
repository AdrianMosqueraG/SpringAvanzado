package com.example.DBA1.QuerysAvanzadas.profesor.infrastructure.controller;

import com.example.DBA1.QuerysAvanzadas.profesor.application.service.interfaz.ProfesorService;
import com.example.DBA1.QuerysAvanzadas.profesor.domain.dto.output.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping("/getId/{id}")
    public ProfesorOutputDto getId(@PathVariable int id) throws Exception{
        return profesorService.buscarPorId(id);
    }

    @GetMapping("/getBranch/{branch}")
    public List<ProfesorOutputDto> getBranch(@PathVariable String branch){
        return profesorService.buscarPorBranch(branch);
    }
}
