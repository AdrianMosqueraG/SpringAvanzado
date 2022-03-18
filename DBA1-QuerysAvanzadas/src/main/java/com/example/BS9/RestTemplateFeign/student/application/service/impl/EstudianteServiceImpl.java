package com.example.BS9.RestTemplateFeign.student.application.service.impl;

import com.example.BS9.RestTemplateFeign.student.application.service.interfaz.EstudianteService;
import com.example.BS9.RestTemplateFeign.student.domain.dto.output.EstudianteOutputDto;
import com.example.BS9.RestTemplateFeign.student.domain.entity.Estudiante;
import com.example.BS9.RestTemplateFeign.student.infrastructure.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    private EstudianteOutputDto converToDto(Estudiante estudiante){
        return new EstudianteOutputDto(estudiante);
    }

    @Override
    public EstudianteOutputDto buscarPorId(int id) throws Exception {
        EstudianteOutputDto estudianteOutputDto = new EstudianteOutputDto(estudianteRepository.findById(id));
        if (estudianteOutputDto != null){
            return estudianteOutputDto;
        }else {
            throw new Exception("No existe nigun estudiante con ese ID");
        }
    }

    @Override
    public List<EstudianteOutputDto> buscarPorName(String name) {
        return estudianteRepository.findByName(name)
                .stream()
                .map(this::converToDto)
                .collect(Collectors.toList());
    }
}
