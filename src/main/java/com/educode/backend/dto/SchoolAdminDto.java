package com.educode.backend.dto;

import com.educode.backend.entities.Message;
import com.educode.backend.entities.Notification;
import com.educode.backend.entities.School;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolAdminDto {
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

    @OneToMany
    private List<NotificationDto> notificationDtos;

    @OneToMany
    private List<MessageDto> messageDtos;

    @ManyToOne
    private SchoolDto schoolDto;
}
