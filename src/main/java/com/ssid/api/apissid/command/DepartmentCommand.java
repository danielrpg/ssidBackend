package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.Department;
import com.ssid.api.apissid.domain.Position;

import java.util.ArrayList;

/**
 * @author Jesus David Piérola Alvarado
 */

public class DepartmentCommand {
    private Long id;
    private String name;
    private String description;
    private ArrayList<PositionCommand> positions = new ArrayList<>();

    public DepartmentCommand() {
    }

    public DepartmentCommand(Department department) {
        setId(department.getId());
        setName(department.getName());
        setDescription(department.getDescription());
        positions = new ArrayList<PositionCommand>();

        if(department.getPositions() != null &&
                !department.getPositions().isEmpty() &&
                department.getPositions().size() > 0) {
            for (Position pos : department.getPositions()) {
                positions.add(new PositionCommand(pos));
            }

            setPositions(positions);
        }
    }

    public Department toDepartment() {
        Department department = new Department();

        department.setId(getId());
        department.setName(getName());
        department.setDescription(getDescription());

        return department;
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

    public ArrayList<PositionCommand> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<PositionCommand> positions) {
        this.positions = positions;
    }
}
