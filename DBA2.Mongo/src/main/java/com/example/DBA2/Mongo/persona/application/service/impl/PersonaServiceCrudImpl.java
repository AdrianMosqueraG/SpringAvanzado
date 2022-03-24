package com.example.DBA2.Mongo.persona.application.service.impl;

import com.example.DBA2.Mongo.persona.application.service.interfaces.PersonaCrudService;
import com.example.DBA2.Mongo.persona.domain.entity.Persona;
import com.example.DBA2.Mongo.persona.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceCrudImpl implements PersonaCrudService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Persona savePersona(Persona persona) {
        personaRepository.save(persona);
        return persona;
    }

    @Override
    public List<Persona> getAllPersona() {
        return personaRepository.findAll();
    }

    @Override
    public Persona updateOnePersona(Persona persona) throws Exception {
        Persona personaExistente = mongoTemplate.findById(persona.getId_persona(), Persona.class);

        if (personaExistente != null){

            if (persona.getName() != null){
                personaExistente.setName(persona.getName());
            }
            if (persona.getPassword() != null){
                personaExistente.setPassword(persona.getPassword());
            }
            if (persona.getEmail() != null){
                personaExistente.setEmail(persona.getEmail());
            }
            if (persona.getCity() != null){
                personaExistente.setCity(persona.getCity());
            }
            if (persona.getFechaNac() != null){
                personaExistente.setFechaNac(persona.getFechaNac());
            }

            personaRepository.save(personaExistente);

            return personaExistente;
        }else {
            throw new Exception("ID incorrecto o inexistente");
        }

    }

    @Override
    public void deletePersona(String id) {
        personaRepository.delete(mongoTemplate.findById(id, Persona.class));
    }
}
