package com.example.DBA2.Mongo.estudiante.application.service.impl;

import com.example.DBA2.Mongo.estudiante.application.service.interfaces.EstudianteService;
import com.example.DBA2.Mongo.estudiante.domain.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Estudiante> getAllEstudiantePaginated(int pageNumber, int pageSize) {
        Query query = new Query();
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);

        return mongoTemplate.find(query, Estudiante.class);
    }

    ///ERRRRRRROOOOOORRRRRR
    @Override
    public Estudiante findOneByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));

        return mongoTemplate.findOne(query, Estudiante.class);
    }

    @Override
    public List<Estudiante> findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));

        return mongoTemplate.find(query, Estudiante.class);
    }
}
