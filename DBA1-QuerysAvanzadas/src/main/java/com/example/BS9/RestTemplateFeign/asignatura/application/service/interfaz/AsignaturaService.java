package com.example.BS9.RestTemplateFeign.asignatura.application.service.interfaz;

import com.example.BS9.RestTemplateFeign.asignatura.domain.dto.output.AsignaturaOutputDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignaturaService {
    AsignaturaOutputDto buscarPorId(int id) throws Exception;
    List<AsignaturaOutputDto> buscarPorNombre(String nombre);
}
