package com.educode.backend.services;

import com.educode.backend.dto.SchoolDto;
import com.educode.backend.helpers.SchoolMapper;
import com.educode.backend.repositories.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    final private SchoolRepository schoolRepository;

    final private SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }
    public SchoolDto createSchool(SchoolDto schoolDto) {
        schoolRepository.save(schoolMapper.toEntity(schoolDto));
        return schoolDto;
    }

    public List<SchoolDto> getAllSchools() {
        return schoolRepository.findAll().stream().map(schoolMapper::toDto).collect(Collectors.toList());
    }

    public SchoolDto getSchoolById(Long id) {
        return schoolMapper.toDto(schoolRepository.findById(id).get());
    }

    public SchoolDto updateSchool(SchoolDto schoolDto) {
        schoolRepository.save(schoolMapper.toEntity(schoolDto));
        return schoolDto;
    }

    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }
}
