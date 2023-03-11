package com.educode.backend.controllers;

import com.educode.backend.dto.SchoolAdminDto;
import com.educode.backend.services.SchoolAdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school-admin")
public class SchoolAdminController {

    final private SchoolAdminService schoolAdminService;

    public SchoolAdminController(SchoolAdminService schoolAdminService) {
        this.schoolAdminService = schoolAdminService;
    }

    @PostMapping
    public ResponseEntity createSchoolAdmin(@RequestBody SchoolAdminDto schoolAdminDto) {
        return new ResponseEntity<>(schoolAdminService.createSchoolAdmin(schoolAdminDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SchoolAdminDto>> getAllSchoolAdmins() {
        return new ResponseEntity<>(schoolAdminService.getAllSchoolAdmins(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolAdminDto> getSchoolAdminById(@PathVariable Long id) {
        return new ResponseEntity<>(schoolAdminService.getSchoolAdminById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SchoolAdminDto> updateSchoolAdmin(@RequestBody SchoolAdminDto schoolAdminDto) {
        return new ResponseEntity<>(schoolAdminService.updateSchoolAdmin(schoolAdminDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchoolAdmin(@PathVariable Long id) {
        return new ResponseEntity<>(schoolAdminService.deleteSchoolAdmin(id), HttpStatus.OK);
    }


}
