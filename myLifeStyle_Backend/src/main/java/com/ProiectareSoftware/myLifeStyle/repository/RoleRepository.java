package com.ProiectareSoftware.myLifeStyle.repository;

import com.ProiectareSoftware.myLifeStyle.model.ERole;
import com.ProiectareSoftware.myLifeStyle.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRole(ERole role);
}
