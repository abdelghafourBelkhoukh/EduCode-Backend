package com.educode.backend.controllers;


import com.educode.backend.dto.StudentDto;
import com.educode.backend.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    final private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(studentService.createStudent(studentDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(studentService.updateStudent(studentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/id/{email}")
    public ResponseEntity<Long> getStudentIdByEmail(@PathVariable String email) {
        return new ResponseEntity<>(studentService.getStudentIdByEmail(email), HttpStatus.OK);
    }

    @PutMapping("/assignToPromo/{id}")
    public ResponseEntity<StudentDto> assignStudentToPromo(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(studentService.assignStudentToPromo(id, studentDto), HttpStatus.OK);
    }

    @GetMapping("/promo/{promoId}")
    public ResponseEntity<List<StudentDto>> getStudentsByPromoId(@PathVariable Long promoId) {
        return new ResponseEntity<>(studentService.getStudentsByPromoId(promoId), HttpStatus.OK);
    }
}
