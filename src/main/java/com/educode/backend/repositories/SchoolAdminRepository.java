package com.educode.backend.repositories;

import com.educode.backend.entities.SchoolAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolAdminRepository extends JpaRepository<SchoolAdmin, Long> {
}
