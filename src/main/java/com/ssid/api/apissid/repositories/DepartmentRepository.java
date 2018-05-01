package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Created by Jesus David Piérola Alvarado
 */
public interface DepartmentRepository extends JpaRepository<Department, Long>{
    //@Query("SELECT d FROM department d WHERE d.department_name like ?1")
    Optional<List<Department>> findByName(String name);
}
