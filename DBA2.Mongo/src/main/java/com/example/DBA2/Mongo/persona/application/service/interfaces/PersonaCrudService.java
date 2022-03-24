package com.example.DBA2.Mongo.persona.application.service.interfaces;

import com.example.DBA2.Mongo.persona.domain.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaCrudService {

    Persona savePersona(Persona persona);
    List<Persona> getAllPersona();
    Persona updateOnePersona(Persona persona) throws Exception;
    void deletePersona(String id);

}
