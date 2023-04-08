package com.educode.backend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rendu {

    @Id @GeneratedValue
    private Long id;
    private String link;
    private String message;
    private Long student_id;
    private Long exam_id;

    @OneToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

}
