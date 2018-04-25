package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Equipament;

import java.util.List;
import java.util.Optional;

/**
 * @author daniel fernandez
 */
public interface EquipamentService {

    List<Equipament> getListEquipament();

    void saveEquipament(Equipament equipament);

    Optional<Equipament> getEquipamentById(Long id);

    void deleteEquipamentById(Long id);

    Equipament updateEquipament(Equipament equipament, Long id);
}
