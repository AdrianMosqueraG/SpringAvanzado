package com.example.DBA2.Mongo.estudiante.application.service.interfaces;

import com.example.DBA2.Mongo.estudiante.domain.entity.Estudiante;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteService {

    List<Estudiante> getAllEstudiantePaginated(int pageNumber, int pageSize);
    Estudiante findOneByName(String name);
    List<Estudiante> findByName(String name);
}
