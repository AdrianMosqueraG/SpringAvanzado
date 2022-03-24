package com.example.DBA2.Mongo.persona.domain.dto.input;

import com.example.DBA2.Mongo.persona.domain.entity.Persona;
import lombok.Data;

import java.util.Date;

@Data
public class PersonaInputDto {

    String id_persona;
    String name;
    String password;
    String email;
    String city;
    Date fechaNac;

    public Persona persona(){
        Persona persona = new Persona();
        persona.setId_persona(this.getId_persona());
        persona.setPassword(this.getPassword());
        persona.setName(this.getName());
        persona.setCity(this.getCity());
        persona.setFechaNac(this.getFechaNac());

        return persona;
    }

}
