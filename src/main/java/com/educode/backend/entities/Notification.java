package com.educode.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String notificationMessage;
    private String notificationDate;
    private String notificationTime;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Formateur formateur;

    @ManyToOne
    private SchoolAdmin schoolAdmin;





}
