package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.KardexEquipament;
import com.ssid.api.apissid.repositories.KardexEquipamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KardexEquipamentServiceImpl implements KardexEquipamentService {
    private KardexEquipamentRepository kardexEquipamentRepository;

    @Autowired
    public KardexEquipamentServiceImpl(KardexEquipamentRepository kardexEquipamentRepository) {
        this.kardexEquipamentRepository = kardexEquipamentRepository;
    }

    @Transactional
    @Override
    public List<KardexEquipament> getListKardexEquipament() {
        return this.kardexEquipamentRepository.findAll();
    }

    @Transactional
    @Override
    public void saveKardexEquipament(KardexEquipament kardexEquipament) {
        this.kardexEquipamentRepository.save(kardexEquipament);
    }

    @Transactional
    @Override
    public Optional<KardexEquipament> getKardexEquipamentById(Long id) {
        return this.kardexEquipamentRepository.findById(id);
    }

    @Transactional
    @Override
    public void deleteKardexEquipamentById(Long id) {
        Optional<KardexEquipament> kardexEquipament = this.kardexEquipamentRepository.findById(id);
        this.kardexEquipamentRepository.delete(kardexEquipament.get());
    }

    @Transactional
    @Override
    public KardexEquipament updateKardexEquipament(KardexEquipament kardexEquipament, Long id) {
        Optional<KardexEquipament> updateKardex = this.kardexEquipamentRepository.findById(id);
        if(!updateKardex.isPresent())
            return null;
        kardexEquipament.setId(id);
        this.kardexEquipamentRepository.save(kardexEquipament);
        return kardexEquipament;
    }

    @Transactional
    @Override
    public List<KardexEquipament> getKardexByIdEquipment(Long id) {
        List<KardexEquipament> neo = new ArrayList<>();
        List<KardexEquipament> old = this.getListKardexEquipament();
        for(int i = 0; i < old.size(); i++) {
            if(old.get(i).getEquipament().getId().intValue()==id.intValue())
            {
                neo.add(old.get(i));
            }
        }
        return neo;
    }
}
