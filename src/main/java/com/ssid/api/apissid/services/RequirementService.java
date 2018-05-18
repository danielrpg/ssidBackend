package com.ssid.api.apissid.services;

import com.ssid.api.apissid.command.RequirementCommand;
import com.ssid.api.apissid.domain.Position;
import com.ssid.api.apissid.domain.Requirement;

import java.util.List;

public interface RequirementService extends GenericService<Requirement> {
    List<Requirement> findByName(String name);
    Requirement createRequirement(RequirementCommand requirementCommand);
    boolean updateRequirement(RequirementCommand requirementCommand, Long id);
    void saveRequirements(Requirement requirement);
    List<Requirement> findByPosition(Position position);


}
