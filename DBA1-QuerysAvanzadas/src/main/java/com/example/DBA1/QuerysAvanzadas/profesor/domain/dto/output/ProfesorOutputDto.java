package com.example.DBA1.QuerysAvanzadas.profesor.domain.dto.output;

import com.example.DBA1.QuerysAvanzadas.persona.domain.entity.Persona;
import com.example.DBA1.QuerysAvanzadas.profesor.domain.entity.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfesorOutputDto {

    Integer id_profesor;
    String coments;
    String branch;
    Persona persona;

    public ProfesorOutputDto(Profesor p){
        setId_profesor(p.getId_profesor());
        setComents(p.getComents());
        setBranch(p.getBranch());
        setPersona(p.getPersona());
    }

}
