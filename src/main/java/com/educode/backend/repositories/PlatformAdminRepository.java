package com.educode.backend.repositories;

import com.educode.backend.entities.PlatformAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlatformAdminRepository extends JpaRepository<PlatformAdmin, Long> {
    PlatformAdmin findByEmailAndPassword(String email, String password);

    <Optional> PlatformAdmin findByEmail(String email);

    Optional<PlatformAdmin> findPersonByEmail(String email);
}