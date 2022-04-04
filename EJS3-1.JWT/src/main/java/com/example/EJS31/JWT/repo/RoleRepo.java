package com.example.EJS31.JWT.repo;

import com.example.EJS31.JWT.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName (String name);
}
