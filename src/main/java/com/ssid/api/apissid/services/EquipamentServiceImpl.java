package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Equipament;
import com.ssid.api.apissid.repositories.EquipamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author daniel fernandez
 */
@Service
public class EquipamentServiceImpl implements EquipamentService{

    private EquipamentRepository equipamentRepository;

    public EquipamentServiceImpl(EquipamentRepository equipamentRepository) {
        this.equipamentRepository = equipamentRepository;
    }

    @Override
    public List<Equipament> getListEquipament() {
        return this.equipamentRepository.findAll();
    }

    @Override
    public void saveEquipament(Equipament equipament) {
        this.equipamentRepository.save(equipament);
    }

    @Override
    public Optional<Equipament> getEquipamentById(Long id) {
        return this.equipamentRepository.findById(id);
    }
}
