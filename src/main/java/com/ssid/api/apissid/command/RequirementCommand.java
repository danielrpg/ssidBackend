package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.Area;
import com.ssid.api.apissid.domain.Requirement;

/**
 * @author Jesus David Piérola Alvarado
 */

public class RequirementCommand {
    private Long id;
    private String name;
    private String description;

    public RequirementCommand() {
    }

    public RequirementCommand(Requirement requirement) {
        setId(requirement.getId());
        setName(requirement.getName());
        setDescription(requirement.getDescription());
    }

    public Requirement toRequirement() {
        Requirement requirement = new Requirement();

        requirement.setId(getId());
        requirement.setName(getName());
        requirement.setDescription(getDescription());

        return requirement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
