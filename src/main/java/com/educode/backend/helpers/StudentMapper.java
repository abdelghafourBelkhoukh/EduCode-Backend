package com.educode.backend.helpers;

import com.educode.backend.dto.StudentDto;
import com.educode.backend.entities.Student;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentMapper {
    public Student toEntity(StudentDto studentDto) {
        Student student = new Student();
        if (studentDto.getId() != null){
            student.setId(studentDto.getId());
        }
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setPhone(studentDto.getPhone());
        student.setAddress(studentDto.getAddress());
        student.setPassword(studentDto.getPassword());
        student.setCity(studentDto.getCity());
        student.setState(studentDto.getState());
        student.setZip(studentDto.getZip());
        student.setCountry(studentDto.getCountry());
        student.setSchool_id(studentDto.getSchool_id());
        student.setPromo_id(studentDto.getPromo_id());

        return student;
    }

    public  StudentDto toDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setPhone(student.getPhone());
        studentDto.setPassword(student.getPassword());
        studentDto.setAddress(student.getAddress());
        studentDto.setCity(student.getCity());
        studentDto.setState(student.getState());
        studentDto.setZip(student.getZip());
        studentDto.setCountry(student.getCountry());
        studentDto.setSchool_id(student.getSchool_id());
        studentDto.setPromo_id(student.getPromo_id());

        return studentDto;
    }
}
