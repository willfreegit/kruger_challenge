package com.will.vaccination.role.domain;

import com.will.vaccination.role.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Roles, Long> {
    Roles findByName(String name);

}
