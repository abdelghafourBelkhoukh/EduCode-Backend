package com.educode.backend.security;

import com.educode.backend.dto.AuthDto;
import com.educode.backend.helpers.AuthMapper;
import com.educode.backend.repositories.*;
import com.educode.backend.roleEnum.Role;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

@Configuration
@RequiredArgsConstructor
public class UserDetails {

    private final FormateurRepository formateurRepository;
    private final AuthMapper authMapper;
    private final PlatformAdminRepository platformAdminRepository;
    private final SchoolAdminRepository schoolAdminRepository;
    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        System.out.println("ur in userDetailsService now :");
        return new UserDetailsService() {
            @Override
            public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                System.out.println("ur in loadUserByUsername now :");
                AuthDto user ;
                if(formateurRepository.findByEmail(email) != null){
                    System.out.println("ur in formateurRepository now :");
                    user = authMapper.authToDto(formateurRepository.findByEmail(email), Role.FORMATEUR);
                } else if(platformAdminRepository.findByEmail(email) != null){
                    System.out.println("ur in platformAdminRepository now :");
                    System.out.println("email :"+email);
                    user = authMapper.authToDto(platformAdminRepository.findByEmail(email), Role.PLATFORM_ADMIN);
                    System.out.println("user :"+user);
                } else if (schoolAdminRepository.findByEmail(email) != null) {
                    System.out.println("ur in schoolAdminRepository now :");
                    user = authMapper.authToDto(schoolAdminRepository.findByEmail(email), Role.SCHOOL_ADMIN);
                } else if (schoolRepository.findByEmail(email) != null) {
                    System.out.println("ur in schoolRepository now :");
                    user = authMapper.authToDto(schoolRepository.findByEmail(email), Role.SCHOOL);
                } else if (studentRepository.findByEmail(email) != null) {
                    System.out.println("ur in studentRepository now :");
                    user = authMapper.authToDto(studentRepository.findByEmail(email), Role.STUDENT);
                } else {
                    System.out.println("ur in else now :");
                    throw new UsernameNotFoundException("User not found with email: " + email);
                }
                if (user != null) {
                    System.out.println("user not null :");
                    System.out.println(user.getRole().toString());
                    String password = user.getPassword();
                    System.out.println("password :"+password);
                    if (StringUtils.isEmpty(password)) {
                        throw new BadCredentialsException("Empty password for user with email: " + email);
                    }
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole().toString());
                    org.springframework.security.core.userdetails.UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                            user.getEmail(),
                            password,
                            Collections.singleton(grantedAuthority));
                    System.out.println("userDetails :"+userDetails);
                    return userDetails;
                }
                return null;
            }
        };
    }
}
