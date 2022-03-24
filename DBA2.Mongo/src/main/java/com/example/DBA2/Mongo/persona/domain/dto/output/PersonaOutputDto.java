package com.example.DBA2.Mongo.persona.domain.dto.output;

import com.example.DBA2.Mongo.persona.domain.entity.Persona;
import lombok.Data;

import java.util.Date;

@Data
public class PersonaOutputDto {

    String id_persona;
    String name;
    String password;
    String email;
    String city;
    Date fechaNac;

    public PersonaOutputDto(Persona p){
        setId_persona(p.getId_persona());
        setPassword(p.getPassword());
        setName(p.getName());
        setCity(p.getCity());
        setFechaNac(p.getFechaNac());
    }

}
