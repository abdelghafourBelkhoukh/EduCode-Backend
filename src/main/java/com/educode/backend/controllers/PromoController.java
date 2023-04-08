package com.educode.backend.controllers;

import com.educode.backend.dto.ExamanDto;
import com.educode.backend.dto.PromoDto;
import com.educode.backend.helpers.PromoMapper;
import com.educode.backend.services.PromoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promo")
public class PromoController {

    final private PromoService promoService;

    public PromoController(PromoService promoService) {
        this.promoService = promoService;
    }

    @PostMapping
    public ResponseEntity<PromoDto> createPromo(@RequestBody PromoDto promoDto) {
        return new ResponseEntity<>(promoService.createPromo(promoDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PromoDto>> getAllPromos() {
        return new ResponseEntity<>(promoService.getAllPromos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromoDto> getPromoById(@PathVariable Long id) {
        return new ResponseEntity<>(promoService.getPromoById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PromoDto> updatePromo(@RequestBody PromoDto promoDto) {
        return new ResponseEntity<>(promoService.updatePromo(promoDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletePromo(@PathVariable Long id) {
        promoService.deletePromo(id);
    }

    @GetMapping("/{id}/examans")
    public ResponseEntity<List<ExamanDto>> getExamansByPromoId(@PathVariable Long id) {
        return new ResponseEntity<>(promoService.getExamansByPromoId(id), HttpStatus.OK);
    }


}
