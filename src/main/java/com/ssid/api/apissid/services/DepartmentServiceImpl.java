package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Department;
import com.ssid.api.apissid.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class DepartmentServiceImpl extends GenericServiceImpl<Department> implements DepartmentService {
    private DepartmentRepository repository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Department> findByName(String name) {
        return StringUtils.isEmpty(name) ? findAll() : repository.findByName(name).get();
    }

    @Override
    public boolean updateDepartment(Department department, Long id) {
        boolean isChanged = false;

        //si existe, actualizamos
        if (repository.existsById(id)) {
            Department departmentDB = findById(id);

            if (departmentDB.getName().compareTo(department.getName()) != 0) {
                departmentDB.setName(department.getName());
                isChanged = true;
            }

            if (departmentDB.getDescription().compareTo(department.getDescription()) != 0) {
                departmentDB.setDescription(department.getDescription());
                isChanged = true;
            }

            if (isChanged) {
                Department departmentSaved = save(departmentDB);

                if (departmentSaved.getId() != null) {
                    return true;
                }
            } else {
                //si no hay cambios a realizar, se confirma como actualizado
                // pero no se realiza ninguna acción
                return true;
            }
        } else {
            //insertamos como nuevo
            save(department);
        }

        return false;
    }

    @Override
    protected JpaRepository<Department, Long> getRepository() {
        return repository;
    }
}
