package com.educode.backend.repositories;

import com.educode.backend.entities.SchoolAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SchoolAdminRepository extends JpaRepository<SchoolAdmin, Long> {
    List<SchoolAdmin> findAllBySchoolId(Long id);

    SchoolAdmin findByEmailAndPassword(String email, String encode);

    <Optional> SchoolAdmin findByEmail(String email);

    Optional<SchoolAdmin> findPersonByEmail(String email);
}
