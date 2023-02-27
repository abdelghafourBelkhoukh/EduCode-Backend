package com.educode.backend.dto;

import com.educode.backend.entities.Examan;
import com.educode.backend.entities.Formateur;
import com.educode.backend.entities.Student;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

public class PromoDto {
    private Long id;
    private String name;
    private String year;

    @ManyToMany
    private List<StudentDto> studentDtos;

    @ManyToOne
    private FormateurDto formateurDto;

    @OneToMany
    private List<ExamanDto> examenDtos;
}
