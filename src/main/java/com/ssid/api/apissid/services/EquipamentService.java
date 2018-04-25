package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Equipament;

import java.util.List;

/**
 * @author daniel fernandez
 */
public interface EquipamentService {

    List<Equipament> getListEquipament();

    void saveEquipament(Equipament equipament);
}
