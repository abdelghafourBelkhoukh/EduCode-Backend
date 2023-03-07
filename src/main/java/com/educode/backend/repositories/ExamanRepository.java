package com.educode.backend.repositories;


import com.educode.backend.entities.Examan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamanRepository extends JpaRepository<Examan, Long> {
}
