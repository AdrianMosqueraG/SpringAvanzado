package com.example.DBA2.Mongo.estudiante.domain.entity;

import com.example.DBA2.Mongo.persona.domain.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Estudiante")
public class Estudiante implements Serializable {

    @Id
    String id_student;
    Integer num_asignaturas;

    @NonNull
    Persona persona;

    public Estudiante(String id_student, Persona persona){
        this.id_student = id_student;
        this.persona = persona;
    }

}
