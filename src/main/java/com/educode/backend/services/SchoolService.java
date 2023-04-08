package com.educode.backend.services;

import com.educode.backend.dto.*;
import com.educode.backend.entities.School;
import com.educode.backend.helpers.*;
import com.educode.backend.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolService {

    final private SchoolRepository schoolRepository;
    final private SchoolAdminRepository schoolAdminRepository;
    final private FormateurRepository formateurRepository;
    final private StudentRepository studentRepository;
    final private PromoRepository promoRepository;
    final private FormateurMapper formateurMapper;
    final private StudentMapper studentMapper;
    final private PromoMapper promoMapper;
    final private SchoolAdminMapper schoolAdminMapper;
    final private SchoolMapper schoolMapper;
    private final PasswordEncoder passwordEncoder;


    public SchoolDto createSchool(SchoolDto schoolDto) {
        schoolDto.setPassword(passwordEncoder.encode(schoolDto.getPassword()));
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
        Optional<School> existingSchoolOptional = schoolRepository.findById(schoolDto.getId());
        if (existingSchoolOptional.isPresent()) {
            School existingSchool = existingSchoolOptional.get();

            // Check if the password has changed
            if (existingSchool.getPassword().equals(schoolDto.getPassword())) {
                // If the password has not changed, then we don't want to re-encode it
                schoolDto.setPassword(existingSchool.getPassword());
            } else {
                // If the password has changed, then we need to re-encode it
                schoolDto.setPassword(passwordEncoder.encode(schoolDto.getPassword()));
            }

            schoolRepository.save(schoolMapper.toEntity(schoolDto));
            return schoolDto;
        } else {
            return null;
        }
    }

    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }
    public List<SchoolDto> getSchoolsByPlatformAdminId(Long id) {
        return schoolRepository.findAllByPlatformAdminId(id).stream().map(schoolMapper::toDto).collect(Collectors.toList());
    }

    public List<SchoolAdminDto> getSchoolAdminsBySchoolId(Long id) {
        return schoolAdminRepository.findAllBySchoolId(id).stream().map(schoolAdminMapper::toDto).collect(Collectors.toList());
    }

    public List<FormateurDto> getFormateursBySchoolId(Long id) {
        return formateurRepository.findAllBySchoolId(id).stream().map(formateurMapper::toDto).collect(Collectors.toList());
    }

    public List<StudentDto> getStudentsBySchoolId(Long id) {
        return studentRepository.findAllBySchoolId(id).stream().map(studentMapper::toDto).collect(Collectors.toList());
    }

    public List<PromoDto> getPromosBySchoolId(Long id) {
        return promoRepository.findAllBySchoolId(id).stream().map(promoMapper::toDto).collect(Collectors.toList());
    }
}
