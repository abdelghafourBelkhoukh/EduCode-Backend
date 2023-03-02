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

    @PostMapping("/create")
    public ResponseEntity<FormateurDto> createFormateur(@RequestBody FormateurDto formateurDto) {
        return new ResponseEntity<>(formateurService.createFormateur(formateurDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FormateurDto>> getAllFormateurs() {
        return new ResponseEntity<>(formateurService.getAllFormateurs(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<FormateurDto> getFormateurById(@PathVariable Long id) {
        return new ResponseEntity<>(formateurService.getFormateurById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<FormateurDto> updateFormateur(@RequestBody FormateurDto formateurDto) {
        return new ResponseEntity<>(formateurService.updateFormateur(formateurDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFormateur(@PathVariable Long id) {
        return new ResponseEntity<>(formateurService.deleteFormateur(id), HttpStatus.OK);
    }
}
