package com.example.DBA1.QuerysAvanzadas.persona.application.service.impl;

import com.example.DBA1.QuerysAvanzadas.persona.application.service.interfaz.PersonaService;
import com.example.DBA1.QuerysAvanzadas.persona.domain.dto.output.PersonaOutputDto;
import com.example.DBA1.QuerysAvanzadas.persona.domain.entity.Persona;
import com.example.DBA1.QuerysAvanzadas.persona.infrastructure.repository.PersonaRepository;
import com.example.DBA1.QuerysAvanzadas.persona.infrastructure.controller.PersonaController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private PersonaOutputDto converToDto(Persona persona){
        return new PersonaOutputDto(persona);
    }

    @Override
    public PersonaOutputDto buscarPorId(int id) throws Exception {
        PersonaOutputDto personaOutputDto = new PersonaOutputDto(personaRepository.findById(id));

        if (personaOutputDto != null){
            return  personaOutputDto;
        }else {
            throw new Exception("No existe ningun usuario con ese ID");
        }
    }

    @Override
    public List<PersonaOutputDto> buscarPorUsuario(String usuario) {
        return personaRepository.findByUsuario(usuario)
                .stream()
                .map(this::converToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Persona> getData(HashMap<String, Object> conditions) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> query= cb.createQuery(Persona.class);
        Root<Persona> root = query.from(Persona.class);

        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field,value) ->
        {
            switch (field){
                case "id":
                    predicates.add(cb.equal(root.get(field), (Integer)value));
                    break;
                case "name":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "address":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "created":
                    String dateCondition=(String) conditions.get("dateCondition");
                    switch (dateCondition)
                    {
                        case PersonaController.GREATER_THAN:
                            predicates.add(cb.greaterThan(root.<Date>get(field),(Date)value));
                            break;
                        case PersonaController.LESS_THAN:
                            predicates.add(cb.lessThan(root.<Date>get(field),(Date)value));
                            break;
                        case PersonaController.EQUAL:
                            predicates.add(cb.equal(root.<Date>get(field),(Date)value));
                            break;
                    }
                    break;
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }
}
