package com.example.DBA1.QuerysAvanzadas.student.application.service.interfaz;

import com.example.DBA1.QuerysAvanzadas.student.domain.dto.input.EstudianteInputDto;
import com.example.DBA1.QuerysAvanzadas.student.domain.dto.output.EstudianteOutputDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteCrudService {
    List<EstudianteOutputDto> getAll();
    EstudianteOutputDto addEstudiante(EstudianteInputDto estudianteInputDto) throws Exception;
    EstudianteOutputDto deleteEstudiante(int id) throws Exception;
    EstudianteOutputDto modifyEstudiante(int id, EstudianteInputDto estudianteInputDto);
}
