package com.educode.backend.controllers;

import com.educode.backend.entities.Rendu;
import com.educode.backend.services.RenduService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rendu")
@RequiredArgsConstructor
public class RenduController {

    final private RenduService renduService;

    @PostMapping
    public void createRendu(@RequestBody Rendu rendu) {
        renduService.createRendu(rendu);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<Rendu>> getRenduByStudentId(@PathVariable Long id) {
        return new ResponseEntity<>(renduService.getRenduByStudentId(id), HttpStatus.OK);
    }


}
