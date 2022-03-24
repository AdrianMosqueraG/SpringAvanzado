package com.example.DBA2.Mongo.persona.application.service.impl;

import com.example.DBA2.Mongo.persona.application.service.interfaces.PersonaService;
import com.example.DBA2.Mongo.persona.domain.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Persona> getAllPersonaPaginated(int pageNumber, int pageSize) {
        Query query = new Query();
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);

        return mongoTemplate.find(query, Persona.class);
    }

    @Override
    public Persona findOneByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));

        return mongoTemplate.findOne(query, Persona.class);
    }

    @Override
    public List<Persona> findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));

        return mongoTemplate.find(query, Persona.class);
    }

}
