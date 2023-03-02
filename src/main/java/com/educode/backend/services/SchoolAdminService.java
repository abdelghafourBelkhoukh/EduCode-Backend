package com.educode.backend.services;

import com.educode.backend.dto.SchoolAdminDto;
import com.educode.backend.helpers.SchoolAdminMapper;
import com.educode.backend.repositories.SchoolAdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolAdminService {

    final private SchoolAdminMapper schoolAdminMapper;
    final private SchoolAdminRepository schoolAdminRepository;

    public SchoolAdminService(SchoolAdminRepository schoolAdminRepository, SchoolAdminMapper schoolAdminMapper) {
        this.schoolAdminRepository = schoolAdminRepository;
        this.schoolAdminMapper = schoolAdminMapper;
    }

    public SchoolAdminDto createSchoolAdmin(SchoolAdminDto schoolAdminDto) {
        schoolAdminRepository.save(schoolAdminMapper.toEntity(schoolAdminDto));
        return schoolAdminDto;
    }

    public List<SchoolAdminDto> getAllSchoolAdmins() {
        return schoolAdminRepository.findAll().stream().map(schoolAdminMapper::toDto).collect(Collectors.toList());
    }

    public SchoolAdminDto getSchoolAdminById(Long id) {
        return schoolAdminMapper.toDto(schoolAdminRepository.findById(id).get());
    }

    public SchoolAdminDto updateSchoolAdmin(SchoolAdminDto schoolAdminDto) {
        schoolAdminRepository.save(schoolAdminMapper.toEntity(schoolAdminDto));
        return schoolAdminDto;
    }

    public String deleteSchoolAdmin(Long id) {
        schoolAdminRepository.deleteById(id);
        return "School admin with id " + id + " deleted";
    }
}
