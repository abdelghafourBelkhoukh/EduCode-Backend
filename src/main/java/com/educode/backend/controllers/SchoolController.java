package com.educode.backend.controllers;


import com.educode.backend.dto.SchoolDto;
import com.educode.backend.services.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/school")
@RestController
public class SchoolController {

    final private SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/create")
    public ResponseEntity<SchoolDto> createSchool(@RequestBody SchoolDto schoolDto) {
        return new ResponseEntity<>(schoolService.createSchool(schoolDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SchoolDto>> getAllSchools() {
        return new ResponseEntity<>(schoolService.getAllSchools(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SchoolDto> getSchoolById(@PathVariable Long id) {
        return new ResponseEntity<>(schoolService.getSchoolById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<SchoolDto> updateSchool(@RequestBody SchoolDto schoolDto) {
        return new ResponseEntity<>(schoolService.updateSchool(schoolDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchool(id);
    }
}
