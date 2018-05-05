package com.ssid.api.apissid.command;


import com.ssid.api.apissid.domain.Requirement;


public class RequirementCommand {
    private Long id;
    private String name;
    private String description;
    private Long position_position_id;
    private String positionName;

    public RequirementCommand() {
    }

    public RequirementCommand(Requirement requirement) {
        //Position position;
        setId(requirement.getId());
        setName(requirement.getName());
        setDescription(requirement.getDescription());
        setPosition_position_id(requirement.getPosition().getId());
        setPositionName(requirement.getPosition().getName());



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

    public Long getPosition_position_id() {
        return position_position_id;
    }

    public void setPosition_position_id(Long position_position_id) {
        this.position_position_id = position_position_id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
