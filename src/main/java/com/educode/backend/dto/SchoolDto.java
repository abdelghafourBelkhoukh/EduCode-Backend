package com.educode.backend.dto;

import com.educode.backend.entities.PlatformAdmin;
import com.educode.backend.entities.SchoolAdmin;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

public class SchoolDto {
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

    @ManyToOne
    private PlatformAdminDto platformAdminDto;

    @OneToMany(mappedBy = "school")
    private List<SchoolAdminDto> schoolAdminDtos;
}
