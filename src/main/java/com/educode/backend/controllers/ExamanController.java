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

    @PostMapping
    public ResponseEntity<ExamanDto> createExaman(@RequestBody ExamanDto examanDto) {
        return new ResponseEntity<>(examanService.createExaman(examanDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ExamanDto>> getAllExamans() {
        return new ResponseEntity<>(examanService.getAllExamans(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamanDto> getExamanById(@PathVariable Long id) {
        return new ResponseEntity<>(examanService.getExamanById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ExamanDto> updateExaman(@RequestBody ExamanDto examanDto) {
        return new ResponseEntity<>(examanService.updateExaman(examanDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteExaman(@PathVariable Long id) {
        examanService.deleteExaman(id);
    }

    @PutMapping("/assignToPromo/{id}")
    public ResponseEntity<ExamanDto> assignExamanToPromo(@PathVariable Long id, @RequestBody ExamanDto examanDto) {
        return new ResponseEntity<>(examanService.assignExamanToPromo(id, examanDto), HttpStatus.OK);
    }


}
