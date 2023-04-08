package com.educode.backend.services;

import com.educode.backend.entities.Rendu;
import com.educode.backend.repositories.RenduRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RenduService {

    final RenduRepository renduRepository;

    public void createRendu(Rendu rendu) {
        renduRepository.save(rendu);
    }

    public List<Rendu> getRenduByStudentId(Long id) {
        return renduRepository.findAllByStudentId(id);
    }
}
