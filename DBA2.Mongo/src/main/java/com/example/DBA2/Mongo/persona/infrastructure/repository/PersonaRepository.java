package com.example.DBA2.Mongo.persona.infrastructure.repository;

import com.example.DBA2.Mongo.persona.domain.entity.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository<Persona, String> {
}
