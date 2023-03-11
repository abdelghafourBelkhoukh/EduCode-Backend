package com.educode.backend.helpers;


import com.educode.backend.dto.ExamanDto;
import com.educode.backend.entities.Examan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExamanMapper {

    public static Examan toEntity(ExamanDto examanDto) {
        Examan examan = new Examan();
        if (examanDto.getId() != null){
            examan.setId(examanDto.getId());
        }
        examan.setTitle(examanDto.getTitle());
        examan.setDescription(examanDto.getDescription());
        examan.setProjectBackround(examanDto.getProjectBackround());
        examan.setCreatedDate(examanDto.getCreatedDate());
        examan.setDeadline(examanDto.getDeadline());
        examan.setPromo_id(examanDto.getPromo_id());
        return examan;
    }


    public ExamanDto toDto(Examan examan) {
        ExamanDto examanDto = new ExamanDto();
        examanDto.setId(examan.getId());
        examanDto.setTitle(examan.getTitle());
        examanDto.setDescription(examan.getDescription());
        examanDto.setProjectBackround(examan.getProjectBackround());
        examanDto.setCreatedDate(examan.getCreatedDate());
        examanDto.setDeadline(examan.getDeadline());
        examanDto.setPromo_id(examan.getPromo_id());
        return examanDto;
    }
}
