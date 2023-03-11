package com.educode.backend.services;


import com.educode.backend.dto.ExamanDto;
import com.educode.backend.dto.PromoDto;
import com.educode.backend.helpers.ExamanMapper;
import com.educode.backend.helpers.PromoMapper;
import com.educode.backend.repositories.ExamanRepository;
import com.educode.backend.repositories.PromoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PromoService {

    final private PromoRepository promoRepository;
    final private ExamanRepository examanRepository;

    final private PromoMapper promoMapper;
    final private ExamanMapper examanMapper;



    public PromoDto createPromo(PromoDto promoDto) {
        promoRepository.save(PromoMapper.toEntity(promoDto));
        return promoDto;
    }

    public PromoDto getPromoById(Long id) {
        return promoMapper.toDto(promoRepository.findById(id).get());
    }

    public PromoDto updatePromo(PromoDto promoDto) {
        promoRepository.save(PromoMapper.toEntity(promoDto));
        return promoDto;
    }

    public String deletePromo(Long id) {
        promoRepository.deleteById(id);
        return "Promo with id: " + id + " was deleted";
    }

    public List<PromoDto> getAllPromos() {
        return promoRepository.findAll().stream().map(promoMapper::toDto).collect(Collectors.toList());
    }

    public List<ExamanDto> getExamansByPromoId(Long id) {
        return examanRepository.findAllByPromoId(id).stream().map(examanMapper::toDto).collect(Collectors.toList());
    }
}
