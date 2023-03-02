package com.educode.backend.repositories;

import com.educode.backend.entities.PlatformAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformAdminRepository extends JpaRepository<PlatformAdmin, Long> {
}