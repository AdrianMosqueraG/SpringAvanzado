package com.example.BS9.RestTemplateFeign.persona.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSONA")
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    Integer id_persona;

    @Column(name = "usuario")
    String usuario;

    @Column(name = "password")
    String password;

    @Column(name = "name")
    String name;

    @Column(name = "surname")
    String surname;

    @Column(name = "company_email")
    String company_email;

    @Column(name = "personal_email")
    String personal_email;

    @Column(name = "city")
    String city;

    @Column(name = "active")
    Boolean active;

    @Column(name = "created_date")
    String created_date;

    @Column(name = "imagen_url")
    String imagen_url;

    @Column(name = "termination_date")
    String termination_date;

}