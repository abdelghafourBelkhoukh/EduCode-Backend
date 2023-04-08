package com.educode.backend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private Long school_id;
    private Long promo_id;
    @ManyToOne
    @JoinColumn(name = "promo_id", insertable = false, updatable = false)
    private Promo promo;

    @OneToMany(mappedBy = "student")
    private List<Notification> notifications;

    @OneToMany(mappedBy = "student")
    private List<Message> messages;

    @ManyToOne
    @JoinColumn(name = "school_id", insertable = false, updatable = false)
    private School school;

    @OneToOne
    private Rendu rendu;



}
