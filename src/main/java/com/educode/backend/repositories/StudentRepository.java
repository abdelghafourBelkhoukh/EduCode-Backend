package com.educode.backend.repositories;

import com.educode.backend.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllBySchoolId(Long id);

    Student findByEmailAndPassword(String email, String encode);

    <Optional> Student findByEmail(String email);

    Optional<Student> findPersonByEmail(String email);

    List<Student> findAllByPromo_id(Long promo_id);
}
