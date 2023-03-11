package com.educode.backend.helpers;

import com.educode.backend.dto.AuthDto;
import com.educode.backend.dto.PlatformAdminDto;
import com.educode.backend.entities.PlatformAdmin;
import com.educode.backend.roleEnum.Role;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlatformAdminMapper {
    public PlatformAdminDto toDto(PlatformAdmin platformAdmin) {
        PlatformAdminDto platformAdminDto = new PlatformAdminDto();
        platformAdminDto.setId(platformAdmin.getId());
        platformAdminDto.setFistName(platformAdmin.getFistName());
        platformAdminDto.setLastName(platformAdmin.getLastName());
        platformAdminDto.setEmail(platformAdmin.getEmail());
        platformAdminDto.setPassword(platformAdmin.getPassword());
        platformAdminDto.setPhone(platformAdmin.getPhone());
        platformAdminDto.setAddress(platformAdmin.getAddress());
        platformAdminDto.setCity(platformAdmin.getCity());
        platformAdminDto.setState(platformAdmin.getState());
        platformAdminDto.setZip(platformAdmin.getZip());
        platformAdminDto.setCountry(platformAdmin.getCountry());
        return platformAdminDto;
    }

    public PlatformAdmin toEntity(PlatformAdminDto platformAdminDto) {
        PlatformAdmin platformAdmin = new PlatformAdmin();
        if (platformAdminDto.getId() != null){
            platformAdmin.setId(platformAdminDto.getId());
        }
        platformAdmin.setFistName(platformAdminDto.getFistName());
        platformAdmin.setLastName(platformAdminDto.getLastName());
        platformAdmin.setEmail(platformAdminDto.getEmail());
        platformAdmin.setPassword(platformAdminDto.getPassword());
        platformAdmin.setPhone(platformAdminDto.getPhone());
        platformAdmin.setAddress(platformAdminDto.getAddress());
        platformAdmin.setCity(platformAdminDto.getCity());
        platformAdmin.setState(platformAdminDto.getState());
        platformAdmin.setZip(platformAdminDto.getZip());
        platformAdmin.setCountry(platformAdminDto.getCountry());
        return platformAdmin;
    }


}
