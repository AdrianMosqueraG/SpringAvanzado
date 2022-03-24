package com.example.DBA2.Mongo.estudiante.domain.dto.output;

import com.example.DBA2.Mongo.estudiante.domain.entity.Estudiante;
import com.example.DBA2.Mongo.persona.domain.entity.Persona;
import lombok.Data;

@Data
public class EstudianteOutputDto {

    String id_student;
    Integer num_asignaturas;

    Persona persona;

    public EstudianteOutputDto(Estudiante e){
        setId_student(e.getId_student());
        setNum_asignaturas(e.getNum_asignaturas());
        setPersona(e.getPersona());
    }
}
