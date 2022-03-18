package com.example.BS9.RestTemplateFeign.asignatura.application.service.impl;

import com.example.BS9.RestTemplateFeign.asignatura.application.service.interfaz.AsignaturaService;
import com.example.BS9.RestTemplateFeign.asignatura.domain.dto.output.AsignaturaOutputDto;
import com.example.BS9.RestTemplateFeign.asignatura.domain.entity.Asignatura;
import com.example.BS9.RestTemplateFeign.asignatura.infrastructure.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    private AsignaturaOutputDto converToDto(Asignatura asignatura){return new AsignaturaOutputDto(asignatura);}

    @Override
    public AsignaturaOutputDto buscarPorId(int id) throws Exception {
        AsignaturaOutputDto asignaturaOutputDto = new AsignaturaOutputDto(asignaturaRepository.findById(id));

        if(asignaturaOutputDto != null){
            return asignaturaOutputDto;
        }else {
            throw new Exception("No existe ninguna asignatura con ese ID");
        }
    }

    @Override
    public List<AsignaturaOutputDto> buscarPorNombre(String name) {
        return asignaturaRepository.findByName(name)
                .stream()
                .map(this::converToDto)
                .collect(Collectors.toList());
    }
}
