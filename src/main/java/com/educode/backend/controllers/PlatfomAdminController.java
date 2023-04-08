package com.educode.backend.controllers;

import com.educode.backend.dto.PlatformAdminDto;
import com.educode.backend.dto.SchoolDto;
import com.educode.backend.services.PlatformAdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/api/platform-admin")
public class PlatfomAdminController {

    final private PlatformAdminService platformAdminService;

    public PlatfomAdminController(PlatformAdminService platformAdminService) {
        this.platformAdminService = platformAdminService;
    }

    @PostMapping
    public ResponseEntity<PlatformAdminDto> createPlatformAdmin(@RequestBody PlatformAdminDto platformAdminDto) {
        return new ResponseEntity<>(platformAdminService.createPlatformAdmin(platformAdminDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlatformAdminDto>> getAllPlatformAdmins() {
        return new ResponseEntity<>(platformAdminService.getAllPlatformAdmins(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatformAdminDto> getPlatformAdminById(@PathVariable Long id) {
        return new ResponseEntity<>(platformAdminService.getPlatformAdminById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PlatformAdminDto> updatePlatformAdmin(@RequestBody PlatformAdminDto platformAdminDto) {
        return new ResponseEntity<>(platformAdminService.updatePlatformAdmin(platformAdminDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletePlatformAdmin(@PathVariable Long id) {
        platformAdminService.deletePlatformAdmin(id);
    }

    @GetMapping("/{id}/schools")
    public ResponseEntity<List<SchoolDto>> getSchoolsByPlatformAdminId(@PathVariable Long id) {
        return new ResponseEntity<>(platformAdminService.getSchoolsByPlatformAdminId(id), HttpStatus.OK);
    }



}
