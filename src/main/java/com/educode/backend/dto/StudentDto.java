package com.educode.backend.dto;

import com.educode.backend.entities.Message;
import com.educode.backend.entities.Notification;
import com.educode.backend.entities.Promo;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
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
    @ManyToMany
    private List<PromoDto> promoDtos;

    @OneToMany(mappedBy = "student")
    private List<NotificationDto> notificationDtos;

    @OneToMany(mappedBy = "student")
    private List<MessageDto> messageDtos;
}
