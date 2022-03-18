package com.example.DBA1.QuerysAvanzadas.persona.application.service.interfaz;

import com.example.DBA1.QuerysAvanzadas.persona.domain.dto.input.PersonaInputDto;
import com.example.DBA1.QuerysAvanzadas.persona.domain.dto.output.PersonaOutputDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaCrudService {
    List<PersonaOutputDto> getAll();
    PersonaOutputDto addPersona(PersonaInputDto personaInputDto) throws Exception;
    PersonaOutputDto deletePersona(int id) throws Exception;
    PersonaOutputDto modifyPersona(int id, PersonaInputDto personaInputDto);
}
