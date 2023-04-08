package com.educode.backend.repositories;

import com.educode.backend.entities.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long> {
    List<Formateur> findAllBySchoolId(Long id);

    Formateur findByEmailAndPassword(String email, String encode);

    Optional<Formateur> findPersonByEmail(String email);
    Formateur findByEmail(String email);
}
