package com.educode.backend.dto;

import com.educode.backend.entities.Formateur;
import com.educode.backend.entities.SchoolAdmin;
import com.educode.backend.entities.Student;
import jakarta.persistence.ManyToOne;

public class MessageDto {
    private Long id;
    private String message;

    @ManyToOne
    private Student student;

    @ManyToOne
    private FormateurDto formateurDto;

    @ManyToOne
    private SchoolAdminDto schoolAdminDto;
}
