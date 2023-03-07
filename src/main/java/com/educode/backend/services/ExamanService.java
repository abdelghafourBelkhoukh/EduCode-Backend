package com.educode.backend.services;

import com.educode.backend.dto.ExamanDto;
import com.educode.backend.helpers.ExamanMapper;
import com.educode.backend.repositories.ExamanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamanService {

    final private ExamanRepository examanRepository;
    final private ExamanMapper examanMapper;

    public ExamanService(ExamanRepository examanRepository, ExamanMapper examanMapper) {
        this.examanRepository = examanRepository;
        this.examanMapper = examanMapper;
    }

    public ExamanDto createExaman(ExamanDto examanDto) {
        examanRepository.save(ExamanMapper.toEntity(examanDto));
        return examanDto;
    }

    public ExamanDto getExamanById(Long id) {
        return ExamanMapper.toDto(examanRepository.findById(id).get());
    }

    public ExamanDto updateExaman(ExamanDto examanDto) {
        examanRepository.save(ExamanMapper.toEntity(examanDto));
        return examanDto;
    }

    public String deleteExaman(Long id) {
        examanRepository.deleteById(id);
        return "Examan with id: " + id + " was deleted";
    }

    public List<ExamanDto> getAllExamans() {
        return examanRepository.findAll().stream().map(ExamanMapper::toDto).collect(Collectors.toList());
    }


}
