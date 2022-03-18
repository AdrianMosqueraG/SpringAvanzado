package com.example.DBA1.QuerysAvanzadas.profesor.infrastructure.repository;

import com.example.DBA1.QuerysAvanzadas.profesor.domain.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {

    Profesor findById(int id_profesor);

    @Query("select p from Profesor p where p.branch = ?1")
    List<Profesor> findByBranch(String branch);
}
