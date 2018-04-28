package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.KardexEquipament;
import com.ssid.api.apissid.repositories.KardexEquipamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KardexEquipamentServiceImpl implements KardexEquipamentService {
    private KardexEquipamentRepository kardexEquipamentRepository;

    public KardexEquipamentServiceImpl(KardexEquipamentRepository kardexEquipamentRepository) {
        this.kardexEquipamentRepository = kardexEquipamentRepository;
    }

    @Override
    public List<KardexEquipament> getListKardexEquipament() {
        return kardexEquipamentRepository.findAll();
    }

    @Override
    public void saveKardexEquipament(KardexEquipament kardexEquipament) {
        kardexEquipamentRepository.save(kardexEquipament);
    }

    @Override
    public Optional<KardexEquipament> getKardexEquipamentById(Long id) {
        return kardexEquipamentRepository.findById(id);
    }

    @Override
    public void deleteKardexEquipamentById(Long id) {
        Optional<KardexEquipament> kardexEquipament = kardexEquipamentRepository.findById(id);
        kardexEquipamentRepository.delete(kardexEquipament.get());
    }

    @Override
    public KardexEquipament updateKardexEquipament(KardexEquipament kardexEquipament, Long id) {
        Optional<KardexEquipament> updateKardex = kardexEquipamentRepository.findById(id);
        if(!updateKardex.isPresent())
            return null;
        kardexEquipament.setId(id);
        kardexEquipamentRepository.save(kardexEquipament);
        return kardexEquipament;
    }
}
