package com.example.DBA1.QuerysAvanzadas.asignatura.application.service.interfaz;

import com.example.DBA1.QuerysAvanzadas.asignatura.domain.dto.output.AsignaturaOutputDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignaturaService {
    AsignaturaOutputDto buscarPorId(int id) throws Exception;
    List<AsignaturaOutputDto> buscarPorNombre(String nombre);
}
