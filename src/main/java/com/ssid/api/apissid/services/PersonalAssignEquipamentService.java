package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.PersonalAssignEquipament;

import java.util.List;

public interface PersonalAssignEquipamentService {
    List<PersonalAssignEquipament> getPersonalAssignEquipament();

    void setPersonalAssignEquipament(PersonalAssignEquipament personalAssignEquipament);
}

