package com.example.DBA1.QuerysAvanzadas.profesor.domain.entity;

import com.example.DBA1.QuerysAvanzadas.persona.domain.entity.Persona;
import com.example.DBA1.QuerysAvanzadas.student.domain.entity.Estudiante;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PROFESOR")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_profesor;

    @Column(name = "coments")
    String coments;

    @Column(name = "branch")
    String branch;

    @OneToOne
    @JoinColumn(name = "id_Profesor")
    Persona persona;

    @JsonIgnore
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    List<Estudiante> estudiantes = new ArrayList<>();

}
