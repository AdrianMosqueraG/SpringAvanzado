package com.example.DBA1.QuerysAvanzadas.profesor.domain.dto.input;

import com.example.DBA1.QuerysAvanzadas.persona.domain.entity.Persona;
import com.example.DBA1.QuerysAvanzadas.profesor.domain.entity.Profesor;
import lombok.Data;

@Data
public class ProfesorInputDto {

    Integer id_profesor;
    String coments;
    String branch;
    Persona persona;

    public Profesor profesor(){
        Profesor profesor = new Profesor();
        profesor.setId_profesor(this.getId_profesor());
        profesor.setComents(this.getComents());
        profesor.setBranch(this.getBranch());
        profesor.setPersona(this.getPersona());
        return profesor;
    }
}
