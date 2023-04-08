package com.educode.backend.services;

import com.educode.backend.dto.ExamanDto;
import com.educode.backend.helpers.ExamanMapper;
import com.educode.backend.repositories.ExamanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExamanService {

    final private ExamanRepository examanRepository;
    final private ExamanMapper examanMapper;




    public ExamanDto createExaman(ExamanDto examanDto) {
        examanRepository.save(ExamanMapper.toEntity(examanDto));
        return examanDto;
    }

    public ExamanDto getExamanById(Long id) {

        return examanMapper.toDto(examanRepository.findById(id).get());
    }

    public ExamanDto updateExaman(ExamanDto examanDto) {
        examanRepository.save(ExamanMapper.toEntity(examanDto));
        return examanDto;
    }

    public void deleteExaman(Long id) {
        examanRepository.deleteById(id);
    }

    public List<ExamanDto> getAllExamans() {
        return examanRepository.findAll().stream().map(examanMapper::toDto).collect(Collectors.toList());
    }


    public ExamanDto assignExamanToPromo(Long id, ExamanDto examanDto) {
        examanDto.setPromo_id(id);
        examanRepository.save(examanMapper.toEntity(examanDto));
        return examanDto;
    }
}
