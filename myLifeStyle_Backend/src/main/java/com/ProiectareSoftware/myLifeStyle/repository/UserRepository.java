package com.ProiectareSoftware.myLifeStyle.repository;

import com.ProiectareSoftware.myLifeStyle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(@Param("email") String email);

    Boolean existsByEmail(String email);
}
