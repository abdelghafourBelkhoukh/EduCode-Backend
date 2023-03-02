package com.educode.backend.helpers;

import com.educode.backend.dto.FormateurDto;
import com.educode.backend.entities.Formateur;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FormateurMapper {
    public static Formateur toEntity(FormateurDto formateurDto) {
        Formateur formateur = new Formateur();
        if (formateurDto.getId() != null){
            formateur.setId(formateurDto.getId());
        }
        formateur.setFirstName(formateurDto.getFirstName());
        formateur.setLastName(formateurDto.getLastName());
        formateur.setEmail(formateurDto.getEmail());
        formateur.setPhone(formateurDto.getPhone());
        formateur.setPassword(formateurDto.getPassword());
        formateur.setAddress(formateurDto.getAddress());
        formateur.setCity(formateurDto.getCity());
        formateur.setState(formateurDto.getState());
        formateur.setZip(formateurDto.getZip());
        formateur.setCountry(formateurDto.getCountry());

        return formateur;
    }

    public static FormateurDto toDto(Formateur formateur) {
        FormateurDto formateurDto = new FormateurDto();
        formateurDto.setId(formateur.getId());
        formateurDto.setFirstName(formateur.getFirstName());
        formateurDto.setLastName(formateur.getLastName());
        formateurDto.setEmail(formateur.getEmail());
        formateurDto.setPhone(formateur.getPhone());
        formateurDto.setPassword(formateur.getPassword());
        formateurDto.setAddress(formateur.getAddress());
        formateurDto.setCity(formateur.getCity());
        formateurDto.setState(formateur.getState());
        formateurDto.setZip(formateur.getZip());
        formateurDto.setCountry(formateur.getCountry());

        return formateurDto;
    }
}
