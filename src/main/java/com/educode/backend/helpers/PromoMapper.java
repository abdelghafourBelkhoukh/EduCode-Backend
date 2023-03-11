package com.educode.backend.helpers;

import com.educode.backend.dto.PromoDto;
import com.educode.backend.entities.Promo;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PromoMapper {


    public static Promo toEntity(PromoDto promoDto) {
        Promo promo = new Promo();
        if (promoDto.getId() != null){
            promo.setId(promoDto.getId());
        }
        promo.setName(promoDto.getName());
        promo.setYear(promoDto.getYear());
        promo.setSchool_id(promoDto.getSchool_id());
        return promo;
    }

    public PromoDto toDto(Promo promo) {
        PromoDto promoDto = new PromoDto();
        promoDto.setId(promo.getId());
        promoDto.setName(promo.getName());
        promoDto.setYear(promo.getYear());
        promoDto.setSchool_id(promo.getSchool_id());
        return promoDto;
    }
}
