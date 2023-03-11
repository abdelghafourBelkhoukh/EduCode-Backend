package com.educode.backend.services;

import com.educode.backend.dto.StudentDto;
import com.educode.backend.helpers.StudentMapper;
import com.educode.backend.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    final private StudentMapper studentMapper;
    final private StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;


    public StudentDto createStudent(StudentDto studentDto) {
        studentDto.setPassword(passwordEncoder.encode(studentDto.getPassword()));
        studentRepository.save(studentMapper.toEntity(studentDto));
        return studentDto;
    }

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream().map(studentMapper::toDto).collect(Collectors.toList());
    }

    public StudentDto getStudentById(Long id) {
        return studentMapper.toDto(studentRepository.findById(id).get());
    }

    public StudentDto updateStudent(StudentDto studentDto) {
        studentDto.setPassword(passwordEncoder.encode(studentDto.getPassword()));
        studentRepository.save(studentMapper.toEntity(studentDto));
        return studentDto;
    }

    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Student with id: " + id + " was deleted";
    }

    public StudentDto assignStudentToPromo(Long id, StudentDto studentDto) {
        studentDto.setPromo_id(id);
        studentRepository.save(studentMapper.toEntity(studentDto));
        return studentDto;
    }
}
