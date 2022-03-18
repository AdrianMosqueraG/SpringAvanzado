package com.example.DBA1.QuerysAvanzadas.asignatura.infrastructure.controller;

import com.example.DBA1.QuerysAvanzadas.asignatura.application.service.interfaz.AsignaturaCrudService;
import com.example.DBA1.QuerysAvanzadas.asignatura.domain.dto.input.AsignaturaInputDto;
import com.example.DBA1.QuerysAvanzadas.asignatura.domain.dto.output.AsignaturaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaCrudController {

    @Autowired
    private AsignaturaCrudService asignaturaCrudService;

    @GetMapping("/getAll")
    public List<AsignaturaOutputDto> getAll(){return asignaturaCrudService.getAll();}

    @PostMapping("/add")
    public AsignaturaOutputDto addAsignatura(@RequestBody AsignaturaInputDto asignaturaInputDto) throws Exception {
        return asignaturaCrudService.addAsignatura(asignaturaInputDto);
    }

    @DeleteMapping("/delete/{id}")
    public AsignaturaOutputDto deleteId(@PathVariable int id) throws Exception{
        return asignaturaCrudService.deleteAsignatura(id);
    }

    @PutMapping("/mod/{id}")
    public AsignaturaOutputDto updateId(@PathVariable int id, @RequestBody AsignaturaInputDto asignaturaInputDto){
        return asignaturaCrudService.modifyAsignatura(id, asignaturaInputDto);
    }
}
