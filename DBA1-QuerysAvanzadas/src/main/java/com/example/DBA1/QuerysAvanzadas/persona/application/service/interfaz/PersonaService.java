package com.example.DBA1.QuerysAvanzadas.persona.application.service.interfaz;

import com.example.DBA1.QuerysAvanzadas.persona.domain.dto.output.PersonaOutputDto;
import com.example.DBA1.QuerysAvanzadas.persona.domain.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface PersonaService {
    PersonaOutputDto buscarPorId(int id) throws Exception;
    List<PersonaOutputDto> buscarPorUsuario(String usuario);
    List<Persona> getData(HashMap<String, Object> conditions);
}
