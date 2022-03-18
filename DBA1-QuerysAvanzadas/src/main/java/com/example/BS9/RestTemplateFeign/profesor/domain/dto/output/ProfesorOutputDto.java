package com.example.BS9.RestTemplateFeign.profesor.domain.dto.output;

import com.example.BS9.RestTemplateFeign.persona.domain.entity.Persona;
import com.example.BS9.RestTemplateFeign.profesor.domain.entity.Profesor;
import lombok.AllArgsConstructor;
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
