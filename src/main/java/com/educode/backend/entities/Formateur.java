package com.educode.backend.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Getter
@Setter
@Entity
public class Formateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id", insertable = false, updatable = false)
    private School school;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Notification> notifications;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Message> messages;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promo_id", insertable = false, updatable = false)
    private Promo promo;
}
