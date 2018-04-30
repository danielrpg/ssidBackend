package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.Department;

/**
 * @author Jesus David Piérola Alvarado
 */

public class DepartmentCommand {
    private Long id;
    private String name;
    private String description;
    private Object[] positions = new Object[0];

    public DepartmentCommand() {
    }

    public DepartmentCommand(Department department) {
        setId(department.getId());
        setName(department.getName());
        setDescription(department.getDescription());
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

    public Object[] getPositions() {
        return positions;
    }

    public void setPositions(Object[] positions) {
        this.positions = positions;
    }
}
