package com.example.DBA2.Mongo.persona.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Persona")
public class Persona implements Serializable {

    @Id
    String id_persona;
    String name;
    String password;
    String email;
    String city;
    Date fechaNac;

    public Persona(String name, String password, String city, Date fechaNac){
        this.name = name;
        this.password = password;
        this.city = city;
        this.fechaNac = fechaNac;
    }

}