package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.Position;

/**
 * @author Jesus David Piérola Alvarado
 */

public class PositionCommand {
    private Long id;
    private String name;
    private String description;
    private Integer level;
    private Long idParentPosition;
    private String nameParentPosition;
    private String descriptionParentPosition;
    private Integer levelParentPosition;

    public PositionCommand() {
    }

    public PositionCommand(Position position) {
        setId(position.getId());
        setName(position.getName());
        setDescription(position.getDescription());
        setLevel(position.getLevel());

        Position parent = position.getParentPosition();

        if(parent != null) {
            setIdParentPosition(parent.getId());
            setNameParentPosition(parent.getName());
            setDescriptionParentPosition(parent.getDescription());
            setLevelParentPosition(parent.getLevel());
        }
    }

    public Position toPosition() {
        Position position = new Position();

        position.setId(getId());
        position.setName(getName());
        position.setDescription(getDescription());
        position.setLevel(getLevel());

        if(getIdParentPosition() != null && getIdParentPosition() > 0) {
            Position parent = new Position();
            parent.setId(getIdParentPosition());
            parent.setName(getNameParentPosition());
            parent.setDescription(getDescriptionParentPosition());
            parent.setLevel(getLevelParentPosition());
            position.setParentPosition(parent);
        }

        return position;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getIdParentPosition() {
        return idParentPosition;
    }

    public void setIdParentPosition(Long idParentPosition) {
        this.idParentPosition = idParentPosition;
    }

    public String getNameParentPosition() {
        return nameParentPosition;
    }

    public void setNameParentPosition(String nameParentPosition) {
        this.nameParentPosition = nameParentPosition;
    }

    public String getDescriptionParentPosition() {
        return descriptionParentPosition;
    }

    public void setDescriptionParentPosition(String descriptionParentPosition) {
        this.descriptionParentPosition = descriptionParentPosition;
    }

    public Integer getLevelParentPosition() {
        return levelParentPosition;
    }

    public void setLevelParentPosition(Integer levelParentPosition) {
        this.levelParentPosition = levelParentPosition;
    }
}
