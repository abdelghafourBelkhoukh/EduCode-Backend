package com.educode.backend.services;

import com.educode.backend.dto.PlatformAdminDto;
import com.educode.backend.dto.SchoolDto;
import com.educode.backend.helpers.PlatformAdminMapper;
import com.educode.backend.helpers.SchoolMapper;
import com.educode.backend.repositories.PlatformAdminRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PlatformAdminService {
    private final PlatformAdminRepository platformAdminRepository;
    final private PlatformAdminMapper platformAdminMapper;
    final private SchoolMapper schoolMapper;
    private final PasswordEncoder passwordEncoder;

    public PlatformAdminDto createPlatformAdmin(PlatformAdminDto platformAdminDto) {
        platformAdminDto.setPassword(passwordEncoder.encode(platformAdminDto.getPassword()));
        return platformAdminMapper.toDto(platformAdminRepository.save(platformAdminMapper.toEntity(platformAdminDto)));
    }

    public List<PlatformAdminDto> getAllPlatformAdmins() {
        return platformAdminRepository.findAll().stream().map(platformAdminMapper::toDto).collect(Collectors.toList());
    }

    public PlatformAdminDto getPlatformAdminById(Long id) {
        return platformAdminMapper.toDto(platformAdminRepository.findById(id).get());
    }

    public PlatformAdminDto updatePlatformAdmin(PlatformAdminDto platformAdminDto) {
        platformAdminDto.setPassword(passwordEncoder.encode(platformAdminDto.getPassword()));
        platformAdminRepository.save(platformAdminMapper.toEntity(platformAdminDto));
        return platformAdminDto;
    }

    public String deletePlatformAdmin(Long id) {
        platformAdminRepository.deleteById(id);
        return "Platform admin with id " + id + " deleted";
    }

    public List<SchoolDto> getSchoolsByPlatformAdminId(Long id) {
        return platformAdminRepository.findById(id).get().getSchools().stream().map(schoolMapper::toDto).collect(Collectors.toList());
    }
}
