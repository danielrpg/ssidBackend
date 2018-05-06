package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.KardexEquipament;

import java.util.List;
import java.util.Optional;

public interface KardexEquipamentService{
    List<KardexEquipament> getListKardexEquipament();

    void saveKardexEquipament(KardexEquipament kardexEquipament);

    Optional<KardexEquipament> getKardexEquipamentById(Long id);

    void deleteKardexEquipamentById(Long id);

    KardexEquipament updateKardexEquipament(KardexEquipament kardexEquipament, Long id);

    List<KardexEquipament> getKardexByIdEquipment(Long id);
}
