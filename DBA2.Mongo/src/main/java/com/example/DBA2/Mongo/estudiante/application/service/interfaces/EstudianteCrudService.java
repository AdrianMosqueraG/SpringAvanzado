package com.example.DBA2.Mongo.estudiante.application.service.interfaces;

import com.example.DBA2.Mongo.estudiante.domain.entity.Estudiante;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteCrudService {

    Estudiante saveEstudiante(Estudiante estudiante);
    List<Estudiante> getAllEstudiante();
    Estudiante updateOneEstudiante(Estudiante estudiante) throws Exception;
    void deleteEstudiante(String id);
}
