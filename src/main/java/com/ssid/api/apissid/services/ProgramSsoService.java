package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.ProgramSso;

import java.util.List;

public interface ProgramSsoService {
    List<ProgramSso> getProgramsSso();
    void saveProgramSso(ProgramSso programSso);
}
