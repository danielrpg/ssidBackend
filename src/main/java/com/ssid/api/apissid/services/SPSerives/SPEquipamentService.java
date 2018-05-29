package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.Equipament;

import java.util.List;

public interface SPEquipamentService {
    List<Equipament> getAllEquipaments();
    void createEquipament(Equipament equipament);
}
