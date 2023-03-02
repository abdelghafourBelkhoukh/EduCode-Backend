package com.educode.backend.controllers;

import com.educode.backend.dto.PlatformAdminDto;
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

    @PostMapping("/create")
    public ResponseEntity<PlatformAdminDto> createPlatformAdmin(@RequestBody PlatformAdminDto platformAdminDto) {
        return new ResponseEntity<>(platformAdminService.createPlatformAdmin(platformAdminDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PlatformAdminDto>> getAllPlatformAdmins() {
        return new ResponseEntity<>(platformAdminService.getAllPlatformAdmins(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PlatformAdminDto> getPlatformAdminById(@PathVariable Long id) {
        return new ResponseEntity<>(platformAdminService.getPlatformAdminById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<PlatformAdminDto> updatePlatformAdmin(@RequestBody PlatformAdminDto platformAdminDto) {
        return new ResponseEntity<>(platformAdminService.updatePlatformAdmin(platformAdminDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePlatformAdmin(@PathVariable Long id) {
        return new ResponseEntity<>(platformAdminService.deletePlatformAdmin(id), HttpStatus.OK);
    }
}
