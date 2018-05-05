package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.FunctionPosition;


public class FunctionPositionCommand {
    private Long id;
    private String name;
    private String description;
    private String position;
    private Long position_position_id;
    private String positionName;

    public FunctionPositionCommand() {
    }

    public FunctionPositionCommand(FunctionPosition functionPosition) {
        setId(functionPosition.getId());
        setName(functionPosition.getName());
        setDescription(functionPosition.getDescription());
        setPositionName(functionPosition.getPosition().getName());
        setPosition_position_id(functionPosition.getPosition().getId());
    }

    public FunctionPosition toFunctionPosition() {
        FunctionPosition functionPosition = new FunctionPosition();

        functionPosition.setId(getId());
        functionPosition.setName(getName());
        functionPosition.setDescription(getDescription());

        return functionPosition;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
