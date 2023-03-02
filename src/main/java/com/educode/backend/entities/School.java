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
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;

    private Long platform_admin_id;


    @ManyToOne
    @JoinColumn(name = "platform_admin_id", insertable = false, updatable = false)
    private PlatformAdmin platformAdmin;

    @OneToMany(mappedBy = "school")
    private List<SchoolAdmin> schoolAdmins;
}
