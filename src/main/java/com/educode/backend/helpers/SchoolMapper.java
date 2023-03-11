package com.educode.backend.helpers;

import com.educode.backend.dto.AuthDto;
import com.educode.backend.dto.SchoolDto;
import com.educode.backend.entities.PlatformAdmin;
import com.educode.backend.entities.School;
import com.educode.backend.roleEnum.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class SchoolMapper {
    private PlatformAdminMapper platformAdminMapper;

    public School toEntity(SchoolDto schoolDto) {
        School school = new School();
        if (schoolDto.getId() != null) {
            school.setId(schoolDto.getId());
        }
        school.setName(schoolDto.getName());
        school.setEmail(schoolDto.getEmail());
        school.setPassword(schoolDto.getPassword());
        school.setPhone(schoolDto.getPhone());
        school.setAddress(schoolDto.getAddress());
        school.setCity(schoolDto.getCity());
        school.setCountry(schoolDto.getCountry());
        school.setState(schoolDto.getState());
        school.setZip(schoolDto.getZip());
        school.setPlatform_admin_id(schoolDto.getPlatform_admin_id());
        return school;
    }

    public SchoolDto toDto(School school) {
        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setId(school.getId());
        schoolDto.setName(school.getName());
        schoolDto.setEmail(school.getEmail());
        schoolDto.setPassword(school.getPassword());
        schoolDto.setPhone(school.getPhone());
        schoolDto.setAddress(school.getAddress());
        schoolDto.setCity(school.getCity());
        schoolDto.setCountry(school.getCountry());
        schoolDto.setState(school.getState());
        schoolDto.setZip(school.getZip());
        schoolDto.setPlatform_admin_id(school.getPlatform_admin_id());
        return schoolDto;
    }


}
