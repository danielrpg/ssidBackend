package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.PersonalAssignEquipament;
import com.ssid.api.apissid.repositories.PersonalAssignEquipamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalAssignEquipamentServiceImpl implements PersonalAssignEquipamentService {
    private PersonalAssignEquipamentRepository personalAssignEquipamentRepository;

    public PersonalAssignEquipamentServiceImpl(PersonalAssignEquipamentRepository personalAssignEquipamentRepository) {
        this.personalAssignEquipamentRepository = personalAssignEquipamentRepository;
    }

    @Override
    public List<PersonalAssignEquipament> getPersonalAssignEquipament() {
        return this.personalAssignEquipamentRepository.findAll();
    }

    @Override
    public void setPersonalAssignEquipament(PersonalAssignEquipament personalAssignEquipament) {
        this.personalAssignEquipamentRepository.save(personalAssignEquipament);
    }
}




