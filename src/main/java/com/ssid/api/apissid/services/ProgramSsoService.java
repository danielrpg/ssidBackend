package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.ProgramSso;

import java.util.List;
import java.util.Optional;

public interface ProgramSsoService {
    List<ProgramSso> getProgramsSso();
    ProgramSso saveProgramSso(ProgramSso programSso);
    ProgramSso getProgramById(Long id);
    void deleteProgramById(Long id);
    ProgramSso updateProgram(ProgramSso programSso, Long id);
}
