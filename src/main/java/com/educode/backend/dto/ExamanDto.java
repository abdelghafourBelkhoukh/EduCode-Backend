package com.educode.backend.dto;

import com.educode.backend.entities.Promo;
import jakarta.persistence.ManyToOne;

public class ExamanDto {
    private Long id;
    private String title;
    private String description;
    private String projectBackround;
    private String deadline;
    private String createdDate;

    @ManyToOne
    private PromoDto promoDto;
}
