package com.example.DBA2.Mongo.persona.application.service.interfaces;

import com.example.DBA2.Mongo.persona.domain.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaService {

    List<Persona> getAllPersonaPaginated(int pageNumber, int pageSize);
    Persona findOneByName(String name);
    List<Persona> findByName(String name);

}