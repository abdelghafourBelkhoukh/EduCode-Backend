package com.educode.backend.helpers;

import com.educode.backend.dto.AuthDto;
import com.educode.backend.entities.*;
import com.educode.backend.roleEnum.Role;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthMapper {

    public AuthDto authToDto(Object byEmailAndPassword, Role role) {
        Object user = null;
        AuthDto authDto = new AuthDto();

        switch (role) {
            case PLATFORM_ADMIN:
                authDto.setId(((PlatformAdmin) byEmailAndPassword).getId());
                authDto.setFirstName(((PlatformAdmin) byEmailAndPassword).getFistName());
                authDto.setLastName(((PlatformAdmin) byEmailAndPassword).getLastName());
                authDto.setEmail(((PlatformAdmin) byEmailAndPassword).getEmail());
                authDto.setPassword(((PlatformAdmin) byEmailAndPassword).getPassword());
                authDto.setRole(role);
                break;
            case SCHOOL_ADMIN:
                authDto.setId(((SchoolAdmin) byEmailAndPassword).getId());
                authDto.setFirstName(((SchoolAdmin) byEmailAndPassword).getFistName());
                authDto.setLastName(((SchoolAdmin) byEmailAndPassword).getLastName());
                authDto.setEmail(((SchoolAdmin) byEmailAndPassword).getEmail());
                authDto.setPassword(((SchoolAdmin) byEmailAndPassword).getPassword());
                authDto.setRole(role);
                break;
            case STUDENT:
                authDto.setId(((Student) byEmailAndPassword).getId());
                authDto.setFirstName(((Student) byEmailAndPassword).getFirstName());
                authDto.setLastName(((Student) byEmailAndPassword).getLastName());
                authDto.setEmail(((Student) byEmailAndPassword).getEmail());
                authDto.setPassword(((Student) byEmailAndPassword).getPassword());
                authDto.setRole(role);
                break;
            case FORMATEUR:
                authDto.setId(((Formateur) byEmailAndPassword).getId());
                authDto.setFirstName(((Formateur) byEmailAndPassword).getFirstName());
                authDto.setLastName(((Formateur) byEmailAndPassword).getLastName());
                authDto.setEmail(((Formateur) byEmailAndPassword).getEmail());
                authDto.setPassword(((Formateur) byEmailAndPassword).getPassword());
                authDto.setRole(role);
                break;
            case SCHOOL:
                authDto.setId(((School) byEmailAndPassword).getId());
                authDto.setFirstName(((School) byEmailAndPassword).getName());
                authDto.setLastName(((School) byEmailAndPassword).getName());
                authDto.setEmail(((School) byEmailAndPassword).getEmail());
                authDto.setPassword(((School) byEmailAndPassword).getPassword());
                authDto.setRole(role);
                break;
            default:
                break;

        }


        return authDto;
    }
}
