package com.educode.backend.repositories;

import com.educode.backend.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Long> {
    List<School> findAllByPlatformAdminId(Long id);

    School findByEmailAndPassword(String email, String encode);

    <Optional> School findByEmail(String email);

    Optional<School> findPersonByEmail(String email);
}
