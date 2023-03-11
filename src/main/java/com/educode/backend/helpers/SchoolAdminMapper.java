package com.educode.backend.helpers;

import com.educode.backend.dto.AuthDto;
import com.educode.backend.dto.SchoolAdminDto;
import com.educode.backend.entities.SchoolAdmin;
import com.educode.backend.roleEnum.Role;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchoolAdminMapper {
    public SchoolAdmin toEntity(SchoolAdminDto schoolAdminDto) {
        SchoolAdmin schoolAdmin = new SchoolAdmin();
        if (schoolAdminDto.getId() != null){
            schoolAdmin.setId(schoolAdminDto.getId());
        }
        schoolAdmin.setFistName(schoolAdminDto.getFirstName());
        schoolAdmin.setLastName(schoolAdminDto.getLastName());
        schoolAdmin.setEmail(schoolAdminDto.getEmail());
        schoolAdmin.setPassword(schoolAdminDto.getPassword());
        schoolAdmin.setPhone(schoolAdminDto.getPhone());
        schoolAdmin.setAddress(schoolAdminDto.getAddress());
        schoolAdmin.setCity(schoolAdminDto.getCity());
        schoolAdmin.setState(schoolAdminDto.getState());
        schoolAdmin.setZip(schoolAdminDto.getZip());
        schoolAdmin.setCountry(schoolAdminDto.getCountry());
        schoolAdmin.setSchool_id(schoolAdminDto.getSchool_id());
        return schoolAdmin;
    }

    public SchoolAdminDto toDto(SchoolAdmin schoolAdmin) {
        SchoolAdminDto schoolAdminDto = new SchoolAdminDto();
        schoolAdminDto.setId(schoolAdmin.getId());
        schoolAdminDto.setFirstName(schoolAdmin.getFistName());
        schoolAdminDto.setLastName(schoolAdmin.getLastName());
        schoolAdminDto.setEmail(schoolAdmin.getEmail());
        schoolAdminDto.setPassword(schoolAdmin.getPassword());
        schoolAdminDto.setPhone(schoolAdmin.getPhone());
        schoolAdminDto.setAddress(schoolAdmin.getAddress());
        schoolAdminDto.setCity(schoolAdmin.getCity());
        schoolAdminDto.setState(schoolAdmin.getState());
        schoolAdminDto.setZip(schoolAdmin.getZip());
        schoolAdminDto.setCountry(schoolAdmin.getCountry());
        schoolAdminDto.setSchool_id(schoolAdmin.getSchool_id());
        return schoolAdminDto;
    }

    public AuthDto authToDto(SchoolAdmin byUsernameAndPassword) {
        AuthDto authDto = new AuthDto();
        authDto.setId(byUsernameAndPassword.getId());
        authDto.setFirstName(byUsernameAndPassword.getFistName());
        authDto.setLastName(byUsernameAndPassword.getLastName());
        authDto.setEmail(byUsernameAndPassword.getEmail());
        authDto.setRole(Role.SCHOOL_ADMIN);
        return authDto;
    }
}
