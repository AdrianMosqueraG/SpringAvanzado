package com.example.DBA2.Mongo.estudiante.infrastructure.repository;

import com.example.DBA2.Mongo.estudiante.domain.entity.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
}
