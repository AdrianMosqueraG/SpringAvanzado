package com.example.DBA1.QuerysAvanzadas.persona.domain.dto.input;

import com.example.DBA1.QuerysAvanzadas.persona.domain.entity.Persona;
import lombok.Data;

@Data
public class PersonaInputDto {

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

    public Persona persona(){
        Persona persona = new Persona();
        persona.setId_persona(this.getId_persona());
        persona.setUsuario(this.getUsuario());
        persona.setPassword(this.getPassword());
        persona.setName(this.getName());
        persona.setSurname(this.getSurname());
        persona.setCompany_email(this.getCompany_email());
        persona.setPersonal_email(this.getPersonal_email());
        persona.setCity(this.getCity());
        persona.setActive(this.getActive());
        persona.setCreated_date(this.getCreated_date());
        persona.setImagen_url(this.getImagen_url());
        persona.setTermination_date(this.getTermination_date());
        return persona;
    }

}
