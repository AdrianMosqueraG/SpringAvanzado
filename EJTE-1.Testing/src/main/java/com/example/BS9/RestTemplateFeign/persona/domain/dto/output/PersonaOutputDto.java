package com.example.BS9.RestTemplateFeign.persona.domain.dto.output;

import com.example.BS9.RestTemplateFeign.persona.domain.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
        this.setId_persona(p.getId_persona());
        this.setUsuario(p.getUsuario());
        this.setPassword(p.getPassword());
        this.setName(p.getName());
        this.setSurname(p.getSurname());
        this.setCompany_email(p.getCompany_email());
        this.setPersonal_email(p.getPersonal_email());
        this.setCity(p.getCity());
        this.setActive(p.getActive());
        this.setCreated_date(p.getCreated_date());
        this.setImagen_url(p.getImagen_url());
        this.setTermination_date(p.getTermination_date());
    }

}
