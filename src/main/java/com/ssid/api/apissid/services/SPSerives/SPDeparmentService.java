package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.Department;

import java.util.List;

public interface SPDeparmentService {

    List<Department> getAllDepartment();

    Boolean createDepartment(Department department);

    Boolean deleteDepartment(Long idDepartment);

    Department updateDepartment(Long idDepartment, Department department);
}
