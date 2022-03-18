package com.example.BS9.RestTemplateFeign.persona.domain.dto.output;

import com.example.BS9.RestTemplateFeign.persona.domain.entity.Persona;
import lombok.Data;

@Data
public class PersonaOutputDto {

    Integer id_persona;
    String usuario;
    String password;
    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    Boolean active;
    String created_date;
    String imagen_url;
    String termination_date;

    public PersonaOutputDto(Persona p){
        setId_persona(p.getId_persona());
        setUsuario(p.getUsuario());
        setPassword(p.getPassword());
        setName(p.getName());
        setSurname(p.getSurname());
        setCompany_email(p.getCompany_email());
        setPersonal_email(p.getPersonal_email());
        setCity(p.getCity());
        setActive(p.getActive());
        setCreated_date(p.getCreated_date());
        setImagen_url(p.getImagen_url());
        setTermination_date(p.getTermination_date());
    }

}
