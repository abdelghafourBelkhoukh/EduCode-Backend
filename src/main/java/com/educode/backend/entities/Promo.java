package com.educode.backend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Promo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String year;
    private Long school_id;

    @OneToMany
    private List<Student> students;

    @OneToOne
    private Formateur formateur;

    @OneToMany
    private List<Examan> examens;

    @ManyToOne
    @JoinColumn(name = "school_id", insertable = false, updatable = false)
    private School school;


}
