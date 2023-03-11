package com.educode.backend.controllers;


import com.educode.backend.dto.*;
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

    @PostMapping
    public ResponseEntity<SchoolDto> createSchool(@RequestBody SchoolDto schoolDto) {
        return new ResponseEntity<>(schoolService.createSchool(schoolDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SchoolDto>> getAllSchools() {
        return new ResponseEntity<>(schoolService.getAllSchools(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolDto> getSchoolById(@PathVariable Long id) {
        return new ResponseEntity<>(schoolService.getSchoolById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SchoolDto> updateSchool(@RequestBody SchoolDto schoolDto) {
        return new ResponseEntity<>(schoolService.updateSchool(schoolDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable Long id) {

        schoolService.deleteSchool(id);
    }

    @GetMapping("/{id}/schoolAdmins")
    public ResponseEntity<List<SchoolAdminDto>> getSchoolAdminsBySchoolId(@PathVariable Long id) {
        return new ResponseEntity<>(schoolService.getSchoolAdminsBySchoolId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/formateurs")
    public ResponseEntity<List<FormateurDto>> getFormateursBySchoolId(@PathVariable Long id) {
        return new ResponseEntity<>(schoolService.getFormateursBySchoolId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<StudentDto>> getStudentsBySchoolId(@PathVariable Long id) {
        return new ResponseEntity<>(schoolService.getStudentsBySchoolId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/promos")
    public ResponseEntity<List<PromoDto>> getPromosBySchoolId(@PathVariable Long id) {
        return new ResponseEntity<>(schoolService.getPromosBySchoolId(id), HttpStatus.OK);
    }
}
