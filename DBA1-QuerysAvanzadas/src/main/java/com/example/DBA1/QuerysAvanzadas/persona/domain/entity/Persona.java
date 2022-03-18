package com.example.DBA1.QuerysAvanzadas.persona.domain.entity;

import com.example.DBA1.QuerysAvanzadas.profesor.domain.entity.Profesor;
import com.example.DBA1.QuerysAvanzadas.student.domain.entity.Estudiante;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @NonNull
    @Column(name = "usuario")
    String usuario;

    @NonNull
    @Column(name = "password")
    String password;

    @NonNull
    @Column(name = "name")
    String name;

    @NonNull
    @Column(name = "surname")
    String surname;

    @NonNull
    @Column(name = "company_email")
    String company_email;

    @NonNull
    @Column(name = "personal_email")
    String personal_email;

    @NonNull
    @Column(name = "city")
    String city;

    @NonNull
    @Column(name = "active")
    Boolean active;

    @NonNull
    @Column(name = "created_date")
    String created_date;

    @NonNull
    @Column(name = "imagen_url")
    String imagen_url;

    @NonNull
    @Column(name = "termination_date")
    String termination_date;

    @JsonIgnore
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    Profesor profesor;

    @JsonIgnore
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    Estudiante estudiante;


}