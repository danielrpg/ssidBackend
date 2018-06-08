package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.Contract;
import com.ssid.api.apissid.domain.FunctionPosition;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class SPFunctionPositionServiceImpl implements SPFunctionPositionService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<FunctionPosition> getAllFunctions() {
        StoredProcedureQuery query =
                entityManager.createNamedStoredProcedureQuery("sp_getAllFunctions");

        query.execute();

        return (List<FunctionPosition>) query.getResultList();
    }

    @Override
    public Boolean createFunctions(FunctionPosition functionPosition) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_createFunctions");
        query.setParameter("func_name", functionPosition.getName());
        query.setParameter("func_description", functionPosition.getDescription());
        query.setParameter("position_position_id", functionPosition.getPosition());

        query.execute();

        return (Boolean) query.getOutputParameterValue("result");
    }

    @Override
    public Boolean deleteFunctions(Long idFunctions) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_deleteFunctions");
        query.setParameter("func_id", idFunctions);

        query.execute();

        return (Boolean) query.getOutputParameterValue("result");
    }

    @Override
    public Contract updateFunctions(Long idFunctions, FunctionPosition functionPosition) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_editFunctions");
        query.setParameter("func_id", idFunctions);
        query.setParameter("func_name", functionPosition.getName());
        query.setParameter("func_description",functionPosition.getDescription());
        query.setParameter("position_position_id", functionPosition.getPosition());
        query.execute();

        return (Contract) query.getSingleResult();
    }
}
