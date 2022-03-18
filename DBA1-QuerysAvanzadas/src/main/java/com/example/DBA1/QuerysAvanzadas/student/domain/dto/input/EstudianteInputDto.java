package com.example.DBA1.QuerysAvanzadas.student.domain.dto.input;

import com.example.DBA1.QuerysAvanzadas.asignatura.domain.entity.Asignatura;
import com.example.DBA1.QuerysAvanzadas.persona.domain.entity.Persona;
import com.example.DBA1.QuerysAvanzadas.profesor.domain.entity.Profesor;
import com.example.DBA1.QuerysAvanzadas.student.domain.entity.Estudiante;
import lombok.Data;

import java.util.List;

@Data
public class EstudianteInputDto {

    Integer id_student;
    String name;
    Integer num_hours_week;
    String coments;
    String branch;
    Persona persona;
    Profesor profesor;
    List<Asignatura> asignaturas;

    public Estudiante estudiante(){
        Estudiante estudiante = new Estudiante();
        estudiante.setId_student(this.getId_student());
        estudiante.setName(this.getName());
        estudiante.setNum_hours_week(this.getNum_hours_week());
        estudiante.setComents(this.getComents());
        estudiante.setBranch(this.getBranch());
        estudiante.setPersona(this.getPersona());
        estudiante.setProfesor(this.getProfesor());
        estudiante.setAsignaturas(this.getAsignaturas());
        return estudiante;
    }

}
