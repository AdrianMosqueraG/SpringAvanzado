package com.example.BS9.RestTemplateFeign.student.application.service.interfaz;

import com.example.BS9.RestTemplateFeign.student.domain.dto.input.EstudianteInputDto;
import com.example.BS9.RestTemplateFeign.student.domain.dto.output.EstudianteOutputDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteCrudService {
    List<EstudianteOutputDto> getAll();
    EstudianteOutputDto addEstudiante(EstudianteInputDto estudianteInputDto) throws Exception;
    EstudianteOutputDto deleteEstudiante(int id) throws Exception;
    EstudianteOutputDto modifyEstudiante(int id, EstudianteInputDto estudianteInputDto);
}
