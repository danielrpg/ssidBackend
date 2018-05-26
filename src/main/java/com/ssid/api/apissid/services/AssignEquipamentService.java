package com.ssid.api.apissid.services;

import com.ssid.api.apissid.command.AssignEquipamentCommand;
import com.ssid.api.apissid.domain.Equipament;
import com.ssid.api.apissid.domain.Personal;

import java.util.List;

public interface AssignEquipamentService {

    Boolean assignEquipamentToPersonal(AssignEquipamentCommand assignEquipamentCommand);
}
