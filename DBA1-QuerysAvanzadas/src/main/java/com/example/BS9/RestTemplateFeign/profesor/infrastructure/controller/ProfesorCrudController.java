package com.example.BS9.RestTemplateFeign.profesor.infrastructure.controller;

import com.example.BS9.RestTemplateFeign.profesor.application.service.interfaz.ProfesorCrudService;
import com.example.BS9.RestTemplateFeign.profesor.domain.dto.input.ProfesorInputDto;
import com.example.BS9.RestTemplateFeign.profesor.domain.dto.output.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorCrudController {

    @Autowired
    private ProfesorCrudService profesorCrudService;

    @GetMapping("/getAll")
    public List<ProfesorOutputDto> getAll(){
        return profesorCrudService.getAll();
    }

    @PostMapping("/add")
    public ProfesorOutputDto addPerson(@RequestBody ProfesorInputDto profesorInputDto) throws Exception {
        return profesorCrudService.addProfesor(profesorInputDto);
    }

    @DeleteMapping("/delete/{id}")
    public ProfesorOutputDto deleteId(@PathVariable int id) throws Exception {
        return profesorCrudService.deleteProfesor(id);
    }

    @PutMapping("/mod/{id}")
    public ProfesorOutputDto updateId(@PathVariable int id, @RequestBody ProfesorInputDto profesorInputDto){
        return profesorCrudService.modifyProfesor(id, profesorInputDto);
    }
}
