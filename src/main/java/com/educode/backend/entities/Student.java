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
    private String fistName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    @ManyToMany
    private List<Promo> promos;

    @OneToMany(mappedBy = "student")
    private List<Notification> notifications;

    @OneToMany(mappedBy = "student")
    private List<Message> messages;



}
