package com.example.BS9.RestTemplateFeign.profesor.domain.dto.input;

import com.example.BS9.RestTemplateFeign.persona.domain.entity.Persona;
import com.example.BS9.RestTemplateFeign.profesor.domain.entity.Profesor;
import lombok.Data;

import javax.persistence.*;

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
