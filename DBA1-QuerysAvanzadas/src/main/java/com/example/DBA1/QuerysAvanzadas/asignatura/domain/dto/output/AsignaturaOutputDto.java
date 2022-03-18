package com.example.DBA1.QuerysAvanzadas.asignatura.domain.dto.output;

import com.example.DBA1.QuerysAvanzadas.asignatura.domain.entity.Asignatura;
import com.example.DBA1.QuerysAvanzadas.student.domain.entity.Estudiante;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AsignaturaOutputDto {

    Integer id_study;
    String asignatura;
    String comment;
    Date initial_date;
    Date finish_date;
    List<Estudiante> estudiantes;

    public AsignaturaOutputDto(Asignatura a){
        setId_study(a.getId_study());
        setAsignatura(a.getAsignatura());
        setComment(a.getComment());
        setInitial_date(a.getInitial_date());
        setFinish_date(a.getFinish_date());
        setEstudiantes(a.getEstudiantes());
    }
}
