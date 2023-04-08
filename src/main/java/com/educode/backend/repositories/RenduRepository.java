package com.educode.backend.repositories;

import com.educode.backend.entities.Rendu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RenduRepository extends JpaRepository<Rendu, Long> {
    List<Rendu> findAllByStudentId(Long id);
}
