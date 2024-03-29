package com.educode.backend.controllers;

import com.educode.backend.dto.FormateurDto;
import com.educode.backend.helpers.FormateurMapper;
import com.educode.backend.services.FormateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formateur")
public class FormateurController {

    final private FormateurService formateurService;
    final private FormateurMapper formateurMapper;

    public FormateurController(FormateurService formateurService, FormateurMapper formateurMapper) {
        this.formateurService = formateurService;
        this.formateurMapper = formateurMapper;
    }

    @PostMapping
    public ResponseEntity<FormateurDto> createFormateur(@RequestBody FormateurDto formateurDto) {
        return new ResponseEntity<>(formateurService.createFormateur(formateurDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FormateurDto>> getAllFormateurs() {
        return new ResponseEntity<>(formateurService.getAllFormateurs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormateurDto> getFormateurById(@PathVariable Long id) {
        return new ResponseEntity<>(formateurService.getFormateurById(id), HttpStatus.OK);
    }

    @GetMapping("/byemail/{email}")
    public ResponseEntity<FormateurDto> getFormateurByEmail(@PathVariable String email) {
        return new ResponseEntity<>(formateurService.getFormateurByEmail(email), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<FormateurDto> updateFormateur(@RequestBody FormateurDto formateurDto) {
        return new ResponseEntity<>(formateurService.updateFormateur(formateurDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteFormateur(@PathVariable Long id) {
        formateurService.deleteFormateur(id);
    }

    @PutMapping("/assignToPromo/{id}")
    public ResponseEntity<FormateurDto> assignFormateurToPromo(@PathVariable Long id, @RequestBody FormateurDto formateurDto) {
        return new ResponseEntity<>(formateurService.assignFormateurToPromo(id, formateurDto), HttpStatus.OK);
    }

    @GetMapping("/promoId/{email}")
    public ResponseEntity<Long> getPromoIdByFormateurEmail(@PathVariable String email) {
        return new ResponseEntity<>(formateurService.getPromoIdByFormateurEmail(email), HttpStatus.OK);
    }
}
