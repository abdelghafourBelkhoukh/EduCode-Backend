package com.educode.backend.controllers;

import com.educode.backend.dto.SchoolAdminDto;
import com.educode.backend.services.SchoolAdminService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/create")
    public ResponseEntity createSchoolAdmin(@RequestBody SchoolAdminDto schoolAdminDto) {
        return new ResponseEntity<>(schoolAdminService.createSchoolAdmin(schoolAdminDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SchoolAdminDto>> getAllSchoolAdmins() {
        return new ResponseEntity<>(schoolAdminService.getAllSchoolAdmins(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SchoolAdminDto> getSchoolAdminById(@PathVariable Long id) {
        return new ResponseEntity<>(schoolAdminService.getSchoolAdminById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<SchoolAdminDto> updateSchoolAdmin(@RequestBody SchoolAdminDto schoolAdminDto) {
        return new ResponseEntity<>(schoolAdminService.updateSchoolAdmin(schoolAdminDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSchoolAdmin(@PathVariable Long id) {
        return new ResponseEntity<>(schoolAdminService.deleteSchoolAdmin(id), HttpStatus.OK);
    }

}
