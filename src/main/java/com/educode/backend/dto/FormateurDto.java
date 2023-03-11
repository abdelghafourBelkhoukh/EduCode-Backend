package com.educode.backend.dto;

import com.educode.backend.entities.Message;
import com.educode.backend.entities.Notification;
import com.educode.backend.entities.Promo;
import com.educode.backend.roleEnum.Role;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormateurDto {
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
    private Role role = Role.FORMATEUR;
}
