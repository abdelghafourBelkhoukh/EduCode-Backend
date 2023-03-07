package com.educode.backend.controllers;

import com.educode.backend.dto.ExamanDto;
import com.educode.backend.services.ExamanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/examan")
public class ExamanController {

    final private ExamanService examanService;

    public ExamanController(ExamanService examanService) {
        this.examanService = examanService;
    }

    @PostMapping("/create")
    public ResponseEntity<ExamanDto> createExaman(@RequestBody ExamanDto examanDto) {
        return new ResponseEntity<>(examanService.createExaman(examanDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ExamanDto>> getAllExamans() {
        return new ResponseEntity<>(examanService.getAllExamans(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ExamanDto> getExamanById(@PathVariable Long id) {
        return new ResponseEntity<>(examanService.getExamanById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ExamanDto> updateExaman(@RequestBody ExamanDto examanDto) {
        return new ResponseEntity<>(examanService.updateExaman(examanDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExaman(@PathVariable Long id) {
        return new ResponseEntity<>(examanService.deleteExaman(id), HttpStatus.OK);
    }


}
