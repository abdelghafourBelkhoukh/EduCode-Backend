package com.educode.backend.dto;

import com.educode.backend.entities.School;
import com.educode.backend.entities.SchoolAdmin;
import com.educode.backend.roleEnum.Role;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor @AllArgsConstructor
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
    private Role role = Role.PLATFORM_ADMIN;

}
