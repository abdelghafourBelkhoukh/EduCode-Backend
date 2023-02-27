package com.educode.backend.dto;

import com.educode.backend.entities.Message;
import com.educode.backend.entities.Notification;
import com.educode.backend.entities.School;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

public class SchoolAdminDto {
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
    private List<NotificationDto> notificationDtos;

    @OneToMany
    private List<MessageDto> messageDtos;

    @ManyToOne
    private SchoolDto schoolDto;
}
