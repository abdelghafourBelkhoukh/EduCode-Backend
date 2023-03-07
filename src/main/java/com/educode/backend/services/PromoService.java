package com.educode.backend.services;


import com.educode.backend.dto.PromoDto;
import com.educode.backend.helpers.PromoMapper;
import com.educode.backend.repositories.PromoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromoService {

    final private PromoRepository promoRepository;
    final private PromoMapper promoMapper;

    public PromoService(PromoRepository promoRepository, PromoMapper promoMapper) {
        this.promoRepository = promoRepository;
        this.promoMapper = promoMapper;
    }

    public PromoDto createPromo(PromoDto promoDto) {
        promoRepository.save(PromoMapper.toEntity(promoDto));
        return promoDto;
    }

    public PromoDto getPromoById(Long id) {
        return PromoMapper.toDto(promoRepository.findById(id).get());
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
        return promoRepository.findAll().stream().map(PromoMapper::toDto).collect(Collectors.toList());
    }

}
