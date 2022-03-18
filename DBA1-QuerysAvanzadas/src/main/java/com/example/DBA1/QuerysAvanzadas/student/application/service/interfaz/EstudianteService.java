package com.example.DBA1.QuerysAvanzadas.student.application.service.interfaz;

import com.example.DBA1.QuerysAvanzadas.student.domain.dto.output.EstudianteOutputDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteService {
    EstudianteOutputDto buscarPorId(int id) throws Exception;
    List<EstudianteOutputDto> buscarPorName(String name);
}
