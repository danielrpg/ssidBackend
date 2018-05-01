package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.Area;

/**
 * @author Jesus David Piérola Alvarado
 */

public class AreaCommand {
    private Long id;
    private String name;
    private String description;

    public AreaCommand() {
    }

    public AreaCommand(Area area) {
        setId(area.getId());
        setName(area.getName());
        setDescription(area.getDescription());
    }

    public Area toArea() {
        Area area = new Area();

        area.setId(getId());
        area.setName(getName());
        area.setDescription(getDescription());

        return area;
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
