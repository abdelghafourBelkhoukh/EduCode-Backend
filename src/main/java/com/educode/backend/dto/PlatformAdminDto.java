package com.educode.backend.dto;

import com.educode.backend.entities.School;
import com.educode.backend.entities.SchoolAdmin;
import jakarta.persistence.OneToMany;

import java.util.List;

public class PlatformAdminDto {
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

    @OneToMany
    private List<SchoolDto> schoolDtos;

    @OneToMany
    private List<SchoolAdminDto> schoolAdminDtos;
}
