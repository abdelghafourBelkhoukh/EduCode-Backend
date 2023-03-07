package com.educode.backend.dto;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoDto {
    private Long id;
    private String name;
    private String year;

    @ManyToMany
    private List<StudentDto> studentDtos;

    @ManyToOne
    private FormateurDto formateurDto;

    @OneToMany
    private List<ExamanDto> examenDtos;
}
