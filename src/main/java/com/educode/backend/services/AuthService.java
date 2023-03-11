package com.educode.backend.services;

import com.educode.backend.dto.AuthDto;
import com.educode.backend.helpers.AuthMapper;
import com.educode.backend.repositories.*;
import com.educode.backend.roleEnum.Role;
import com.educode.backend.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {


    final private SchoolRepository schoolRepository;
    private final JwtUtils jwtUtils;
    final private PlatformAdminRepository platformAdminRepository;

    final private SchoolAdminRepository schoolAdminRepository;

    final private FormateurRepository formateurRepository;

    final private StudentRepository studentRepository;

    final private AuthMapper authMapper;


    private final PasswordEncoder passwordEncoder;


    public AuthDto login(String email, String password, String role) {
        System.out.println("email: " + email + " password: " + password + " role: " + role);
        AuthDto user = switch (Role.valueOf(role)) {
            case PLATFORM_ADMIN ->{
                var platformAdmin = platformAdminRepository.findByEmail(email);
                if (platformAdmin != null && passwordEncoder.matches(password, platformAdmin.getPassword()))
                    yield authMapper.authToDto(platformAdmin, Role.PLATFORM_ADMIN);
                else throw new IllegalArgumentException("Wrong email or password");
            }
            case SCHOOL_ADMIN -> {
                var schoolAdmin = schoolAdminRepository.findByEmail(email);
                if (schoolAdmin != null && passwordEncoder.matches(password, schoolAdmin.getPassword()))
                    yield authMapper.authToDto(schoolAdmin, Role.SCHOOL_ADMIN);
                else throw new IllegalArgumentException("Wrong email or password");
            }
            case FORMATEUR -> {
                var formateur = formateurRepository.findByEmail(email);
                if (formateur != null && passwordEncoder.matches(password, formateur.getPassword()))
                    yield authMapper.authToDto(formateur, Role.FORMATEUR);
                else throw new IllegalArgumentException("Wrong email or password");
            }
            case STUDENT ->{
                var student = studentRepository.findByEmail(email);
                if (student != null && passwordEncoder.matches(password, student.getPassword()))
                    yield authMapper.authToDto(student, Role.STUDENT);
                else throw new IllegalArgumentException("Wrong email or password");
            }
            case SCHOOL ->{
                var school = schoolRepository.findByEmail(email);
                if (school != null && passwordEncoder.matches(password, school.getPassword()))
                    yield authMapper.authToDto(school, Role.SCHOOL);
                else throw new IllegalArgumentException("Wrong email or password");
            }
            default -> null;
        };
        System.out.println("user : " + user);
        user.setToken(jwtUtils.generateToken(user));
        return user;
    }

}
