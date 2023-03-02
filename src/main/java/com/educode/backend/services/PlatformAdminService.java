package com.educode.backend.services;

import com.educode.backend.dto.PlatformAdminDto;
import com.educode.backend.helpers.PlatformAdminMapper;
import com.educode.backend.repositories.PlatformAdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatformAdminService {
    private final PlatformAdminRepository platformAdminRepository;
    final private PlatformAdminMapper platformAdminMapper;

    public PlatformAdminService(PlatformAdminRepository platformAdminRepository, PlatformAdminMapper platformAdminMapper) {
        this.platformAdminRepository = platformAdminRepository;
        this.platformAdminMapper = platformAdminMapper;
    }

    public PlatformAdminDto createPlatformAdmin(PlatformAdminDto platformAdminDto) {
        platformAdminRepository.save(platformAdminMapper.toEntity(platformAdminDto));
        return platformAdminDto;
    }

    public List<PlatformAdminDto> getAllPlatformAdmins() {
        return platformAdminRepository.findAll().stream().map(platformAdminMapper::toDto).collect(Collectors.toList());
    }

    public PlatformAdminDto getPlatformAdminById(Long id) {
        return platformAdminMapper.toDto(platformAdminRepository.findById(id).get());
    }

    public PlatformAdminDto updatePlatformAdmin(PlatformAdminDto platformAdminDto) {
        platformAdminRepository.save(platformAdminMapper.toEntity(platformAdminDto));
        return platformAdminDto;
    }

    public String deletePlatformAdmin(Long id) {
        platformAdminRepository.deleteById(id);
        return "Platform admin with id " + id + " deleted";
    }
}
