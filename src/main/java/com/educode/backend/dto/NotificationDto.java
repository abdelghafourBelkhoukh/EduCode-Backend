package com.educode.backend.dto;

import com.educode.backend.entities.Formateur;
import com.educode.backend.entities.SchoolAdmin;
import com.educode.backend.entities.Student;
import jakarta.persistence.ManyToOne;

public class NotificationDto {
    private Long id;
    private String notificationMessage;
    private String notificationDate;
    private String notificationTime;

    @ManyToOne
    private StudentDto studentDto;

    @ManyToOne
    private FormateurDto formateurDto;

    @ManyToOne
    private SchoolAdminDto schoolAdminDto;
}
