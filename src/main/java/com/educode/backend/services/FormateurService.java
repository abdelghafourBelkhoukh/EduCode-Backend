package com.educode.backend.services;

import com.educode.backend.dto.FormateurDto;
import com.educode.backend.helpers.FormateurMapper;
import com.educode.backend.repositories.FormateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormateurService {

    final private FormateurRepository formateurRepository;

    public FormateurService(FormateurRepository formateurRepository) {
        this.formateurRepository = formateurRepository;
    }

    public FormateurDto createFormateur(FormateurDto formateurDto) {
        formateurRepository.save(FormateurMapper.toEntity(formateurDto));
        return formateurDto;
    }

    public FormateurDto getFormateurById(Long id) {
        return FormateurMapper.toDto(formateurRepository.findById(id).get());
    }

    public FormateurDto updateFormateur(FormateurDto formateurDto) {
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
}
