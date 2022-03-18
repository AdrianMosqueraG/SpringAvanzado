package com.example.DBA1.QuerysAvanzadas.profesor.application.service.interfaz;

import com.example.DBA1.QuerysAvanzadas.profesor.domain.dto.input.ProfesorInputDto;
import com.example.DBA1.QuerysAvanzadas.profesor.domain.dto.output.ProfesorOutputDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorCrudService {
    List<ProfesorOutputDto> getAll();
    ProfesorOutputDto addProfesor(ProfesorInputDto profesorInputDto) throws Exception;
    ProfesorOutputDto deleteProfesor(int id) throws Exception;
    ProfesorOutputDto modifyProfesor(int id, ProfesorInputDto profesorInputDto);
}
