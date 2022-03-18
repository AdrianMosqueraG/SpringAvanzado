package com.example.BS9.RestTemplateFeign.asignatura.application.service.interfaz;

import com.example.BS9.RestTemplateFeign.asignatura.domain.dto.input.AsignaturaInputDto;
import com.example.BS9.RestTemplateFeign.asignatura.domain.dto.output.AsignaturaOutputDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignaturaCrudService {
    List<AsignaturaOutputDto> getAll();
    AsignaturaOutputDto addAsignatura(AsignaturaInputDto asignaturaInputDto) throws Exception;
    AsignaturaOutputDto deleteAsignatura(int id) throws Exception;
    AsignaturaOutputDto modifyAsignatura(int id, AsignaturaInputDto asignaturaInputDto);
}
