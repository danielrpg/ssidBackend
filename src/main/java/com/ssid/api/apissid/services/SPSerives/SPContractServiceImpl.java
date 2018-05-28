package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.Contract;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class SPContractServiceImpl implements SPContractService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Contract> getAllContracts() {
        StoredProcedureQuery query =
                entityManager.createNamedStoredProcedureQuery("sp_getAllContracts");

        query.execute();

        return (List<Contract>) query.getResultList();
    }

    @Override
    public Boolean createContract(Contract contract) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_createContract");
        query.setParameter("contract_code", contract.getCode());
        query.setParameter("contract_city", contract.getCity());
        query.setParameter("contract_type", contract.getType());
        query.setParameter("contract_date", contract.getDate());
        query.setParameter("contract_salary", contract.getSalary());
        query.setParameter("contract_description", contract.getDescription());


        query.execute();

        return (Boolean) query.getOutputParameterValue("result");
    }

    @Override
    public Boolean deleteContract(Long idContract) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_deleteContract");
        query.setParameter("contract_id", idContract);

        query.execute();

        return (Boolean) query.getOutputParameterValue("result");
    }

    @Override
    public Contract updateContract(Long idContract, Contract contract) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_editContract");
        query.setParameter("contract_id", idContract);
        query.setParameter("contract_code", contract.getCode());
        query.setParameter("contract_city", contract.getCity());
        query.setParameter("contract_type", contract.getType());
        query.setParameter("contract_date", contract.getDate());
        query.setParameter("contract_salary", contract.getSalary());
        query.setParameter("contract_description", contract.getDescription());

        query.execute();

        return (Contract) query.getSingleResult();
    }
}
