package com.example.DBA2.Mongo.estudiante.domain.dto.input;

import com.example.DBA2.Mongo.estudiante.domain.entity.Estudiante;
import com.example.DBA2.Mongo.persona.domain.entity.Persona;
import lombok.Data;

@Data
public class EstudianteInputDto {

    String id_student;
    Integer num_asignaturas;

    Persona persona;

    public Estudiante estudiante(){
        Estudiante estudiante = new Estudiante();
        estudiante.setId_student(this.getId_student());
        estudiante.setNum_asignaturas(this.getNum_asignaturas());
        estudiante.setPersona(this.getPersona());
        return estudiante;
    }
}
