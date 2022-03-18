package com.example.BS9.RestTemplateFeign.asignatura.domain.dto.input;

import com.example.BS9.RestTemplateFeign.asignatura.domain.entity.Asignatura;
import com.example.BS9.RestTemplateFeign.student.domain.entity.Estudiante;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AsignaturaInputDto {

    Integer id_study;
    String asignatura;
    String comment;
    Date initial_date;
    Date finish_date;
    List<Estudiante> estudiantes;

    public Asignatura asignatura(){
        Asignatura asignatura = new Asignatura();
        asignatura.setId_study(this.getId_study());
        asignatura.setAsignatura(this.getAsignatura());
        asignatura.setComment(this.getComment());
        asignatura.setInitial_date(this.getInitial_date());
        asignatura.setFinish_date(this.getFinish_date());
        asignatura.setEstudiantes(this.getEstudiantes());
        return asignatura;
    }

}
