package com.educode.backend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Examan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String projectBackround;
    private String deadline;
    private String createdDate;
    private Long promo_id;

    @ManyToOne
    @JoinColumn(name = "promo_id", insertable = false, updatable = false)
    private Promo promo;
}
