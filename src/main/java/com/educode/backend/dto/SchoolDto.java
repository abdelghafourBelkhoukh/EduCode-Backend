package com.educode.backend.dto;

import com.educode.backend.entities.PlatformAdmin;
import com.educode.backend.entities.SchoolAdmin;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
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
    private Long platform_admin_id;
    @ManyToOne
    @JoinColumn(name = "platform_admin_id", insertable = false, updatable = false)
    private PlatformAdminDto platformAdminDto;

    @OneToMany(mappedBy = "school")
    private List<SchoolAdminDto> schoolAdminDtos;
}
