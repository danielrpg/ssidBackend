package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.Department;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class SPDepartmentServiceImpl implements SPDeparmentService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Department> getAllDepartment() {
        StoredProcedureQuery query =
                entityManager.createNamedStoredProcedureQuery("sp_getAllDepartments");
        query.execute();

        return (List<Department>) query.getResultList();
    }

    @Override
    public Boolean createDepartment(Department department) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_createDepartment");
        query.setParameter("department_description", department.getDescription());
        query.setParameter("department_name", department.getName());

        query.execute();

        return (Boolean) query.getOutputParameterValue("result");
    }

    @Override
    public Boolean deleteDepartment(Long idDepartment) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_deleteDepartment");
        query.setParameter("department_id", idDepartment);

        query.execute();

        return (Boolean) query.getOutputParameterValue("result");
    }

    @Override
    public Department updateDepartment(Long idDepartment, Department department) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_editDepartment");
        query.setParameter("department_id", idDepartment);
        query.setParameter("department_description", department.getDescription());
        query.setParameter("department_name", department.getName());

        query.execute();

        return (Department) query.getSingleResult();
    }

}
