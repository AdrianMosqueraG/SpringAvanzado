package com.example.BS9.RestTemplateFeign.persona.infrastructure.repository;

import com.example.BS9.RestTemplateFeign.persona.domain.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    Persona findById(int id_persona);

    @Query("select p from Persona p where p.usuario = ?1")
    List<Persona> findByUsuario(String user);
}
