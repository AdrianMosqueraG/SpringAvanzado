package com.example.BS9.RestTemplateFeign.student.application.service.interfaz;

import com.example.BS9.RestTemplateFeign.student.domain.dto.output.EstudianteOutputDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteService {
    EstudianteOutputDto buscarPorId(int id) throws Exception;
    List<EstudianteOutputDto> buscarPorName(String name);
}
