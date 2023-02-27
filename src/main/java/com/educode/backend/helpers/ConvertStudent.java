package com.educode.backend.helpers;

import com.educode.backend.dto.StudentDto;
import com.educode.backend.entities.Student;

public class ConvertStudent {

    public static Student toDto (StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setFistName(studentDto.getFistName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setPhone(studentDto.getPhone());
        student.setAddress(studentDto.getAddress());
        student.setCity(studentDto.getCity());
        student.setCountry(studentDto.getCountry());
        student.setZip(studentDto.getZip());
        student.setState(studentDto.getState());
        return student;
    }

    public static StudentDto toEntity (Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFistName(student.getFistName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setPhone(student.getPhone());
        studentDto.setAddress(student.getAddress());
        studentDto.setCity(student.getCity());
        studentDto.setCountry(student.getCountry());
        studentDto.setZip(student.getZip());
        studentDto.setState(student.getState());
        return studentDto;
    }
}
