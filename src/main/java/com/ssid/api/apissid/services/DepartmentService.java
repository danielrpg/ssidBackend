package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Department;

import java.util.List;

/**
 * @author Jesús David Piérola Alvarado
 */
public interface DepartmentService extends GenericService<Department> {
    List<Department> findByName(String name);

    boolean updateDepartment(Department department, Long id);
}
