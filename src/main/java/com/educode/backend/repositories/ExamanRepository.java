package com.educode.backend.repositories;


import com.educode.backend.entities.Examan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ExamanRepository extends JpaRepository<Examan, Long> {
    List<Examan> findAllByPromoId(Long id);
}
