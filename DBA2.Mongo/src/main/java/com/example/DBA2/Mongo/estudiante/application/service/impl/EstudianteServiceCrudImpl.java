package com.example.DBA2.Mongo.estudiante.application.service.impl;

import com.example.DBA2.Mongo.estudiante.application.service.interfaces.EstudianteCrudService;
import com.example.DBA2.Mongo.estudiante.domain.entity.Estudiante;
import com.example.DBA2.Mongo.estudiante.infrastructure.repository.EstudianteRepository;
import com.example.DBA2.Mongo.persona.domain.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceCrudImpl implements EstudianteCrudService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Estudiante saveEstudiante(Estudiante estudiante) {
        estudiante.setId_student(estudiante.getPersona().getId_persona());
        estudiante.setPersona(mongoTemplate.findById(estudiante.getPersona().getId_persona(), Persona.class));
        estudianteRepository.save(estudiante);
        return estudiante;
    }

    @Override
    public List<Estudiante> getAllEstudiante() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante updateOneEstudiante(Estudiante estudiante) throws Exception {
        Estudiante estudianteExistente = mongoTemplate.findById(estudiante.getId_student(), Estudiante.class);

        if (estudianteExistente != null){

            if (estudiante.getNum_asignaturas() != null){
                estudianteExistente.setNum_asignaturas(estudiante.getNum_asignaturas());
            }
            if (estudiante.getPersona() != null){
                estudianteExistente.setPersona(estudiante.getPersona());
            }

            estudianteRepository.save(estudianteExistente);

            return estudianteExistente;
        }else {
            throw new Exception("ID incorrecto o inexistente");
        }
    }

    @Override
    public void deleteEstudiante(String id) {
        estudianteRepository.delete(mongoTemplate.findById(id, Estudiante.class));
    }
}
