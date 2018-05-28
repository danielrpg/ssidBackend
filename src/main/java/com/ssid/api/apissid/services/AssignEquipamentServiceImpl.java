package com.ssid.api.apissid.services;

import com.ssid.api.apissid.command.AssignEquipamentCommand;
import com.ssid.api.apissid.domain.AssignEquipament;
import com.ssid.api.apissid.domain.Equipament;
import com.ssid.api.apissid.repositories.AssignEquipamentRepository;
import org.springframework.stereotype.Service;


@Service
public class AssignEquipamentServiceImpl implements AssignEquipamentService{

    private AssignEquipamentRepository assignEquipamentRepository;

    public AssignEquipamentServiceImpl(AssignEquipamentRepository assignEquipamentRepository) {
        this.assignEquipamentRepository = assignEquipamentRepository;
    }

    @Override
    public Boolean assignEquipamentToPersonal(AssignEquipamentCommand assignEquipamentCommand) {

        for (Equipament equipament: assignEquipamentCommand.getEquipamentList()) {
            AssignEquipament assignEquipament = new AssignEquipament();
            assignEquipament.setPersonal(assignEquipamentCommand.getPersonal());
            assignEquipament.setEquipament(equipament);
            assignEquipament.setNumberAssigned(assignEquipamentCommand.getNumberAssigned());
            this.assignEquipamentRepository.save(assignEquipament);
        }
        return Boolean.TRUE;
    }
}
