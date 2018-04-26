package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.ProgramSso;
import com.ssid.api.apissid.repositories.ProgramSsoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramSsoServiceImpl implements ProgramSsoService {
    private ProgramSsoRepository programSsoRepository;

    public ProgramSsoServiceImpl(ProgramSsoRepository programSsoRepository) {
        this.programSsoRepository = programSsoRepository;
    }

    @Override
    public List<ProgramSso> getProgramsSso() {
        return this.programSsoRepository.findAll();
    }

    @Override
    public void saveProgramSso(ProgramSso programSso) {
        this.programSsoRepository.save(programSso);
    }
}
