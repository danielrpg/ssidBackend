package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Equipament;
import com.ssid.api.apissid.repositories.EquipamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class EquipamentServiceImpl implements EquipamentService{

    private EquipamentRepository equipamentRepository;

    @Autowired
    public EquipamentServiceImpl(EquipamentRepository equipamentRepository) {
        this.equipamentRepository = equipamentRepository;
    }
    @Transactional
    @Override
    public List<Equipament> getListEquipament() {
        return this.equipamentRepository.findAll();
    }

    @Transactional
    @Override
    public void saveEquipament(Equipament equipament) {
        this.equipamentRepository.save(equipament);
    }

    @Transactional
    @Override
    public Optional<Equipament> getEquipamentById(Long id) {
        return this.equipamentRepository.findById(id);
    }

    @Transactional
    @Override
    public void deleteEquipamentById(Long id) {
        Optional<Equipament> equipament = this.equipamentRepository.findById(id);
        this.equipamentRepository.delete(equipament.get());
    }

    @Transactional
    @Override
    public Equipament updateEquipament(Equipament equipament, Long id) {
        Optional<Equipament> equipamentUpdate = this.equipamentRepository.findById(id);
        if(!equipamentUpdate.isPresent())
            return null;
        equipament.setId(id);
        this.equipamentRepository.save(equipament);
        return equipament;
    }
}
