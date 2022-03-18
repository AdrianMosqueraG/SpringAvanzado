package com.example.DBA1.QuerysAvanzadas.asignatura.infrastructure.repository;

import com.example.DBA1.QuerysAvanzadas.asignatura.domain.entity.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {

    public Asignatura findById(int id_asignatura);

    @Query("select a from Asignatura a where a.asignatura = ?1")
    public List<Asignatura> findByName(String user);

}
