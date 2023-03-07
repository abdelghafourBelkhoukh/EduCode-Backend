package com.educode.backend.controllers;

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

    @PostMapping("/create")
    public ResponseEntity<PromoDto> createPromo(@RequestBody PromoDto promoDto) {
        return new ResponseEntity<>(promoService.createPromo(promoDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PromoDto>> getAllPromos() {
        return new ResponseEntity<>(promoService.getAllPromos(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PromoDto> getPromoById(@PathVariable Long id) {
        return new ResponseEntity<>(promoService.getPromoById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<PromoDto> updatePromo(@RequestBody PromoDto promoDto) {
        return new ResponseEntity<>(promoService.updatePromo(promoDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePromo(@PathVariable Long id) {
        return new ResponseEntity<>(promoService.deletePromo(id), HttpStatus.OK);
    }


}
