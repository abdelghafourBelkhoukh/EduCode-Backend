package com.educode.backend.services;

import com.educode.backend.dto.FormateurDto;
import com.educode.backend.helpers.FormateurMapper;
import com.educode.backend.repositories.FormateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FormateurService {

    final private FormateurRepository formateurRepository;
    final private FormateurMapper FormateurMapper;

    private final PasswordEncoder passwordEncoder;

    public FormateurDto createFormateur(FormateurDto formateurDto) {
        formateurDto.setPassword(passwordEncoder.encode(formateurDto.getPassword()));
        return FormateurMapper.toDto(formateurRepository.save(FormateurMapper.toEntity(formateurDto)));
    }

    public FormateurDto getFormateurById(Long id) {
        return FormateurMapper.toDto(formateurRepository.findById(id).get());
    }

    public FormateurDto updateFormateur(FormateurDto formateurDto) {
        formateurDto.setPassword(passwordEncoder.encode(formateurDto.getPassword()));
        formateurRepository.save(FormateurMapper.toEntity(formateurDto));
        return formateurDto;
    }

    public String deleteFormateur(Long id) {
        formateurRepository.deleteById(id);
        return "Formateur with id: " + id + " was deleted";
    }

    public List<FormateurDto> getAllFormateurs() {
        return formateurRepository.findAll().stream().map(FormateurMapper::toDto).collect(Collectors.toList());
    }

    public FormateurDto assignFormateurToPromo(Long id, FormateurDto formateurDto) {
        formateurDto.setPromo_id(id);
        formateurRepository.save(FormateurMapper.toEntity(formateurDto));
        return formateurDto;
    }
}
