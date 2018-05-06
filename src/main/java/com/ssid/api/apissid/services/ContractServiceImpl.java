package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Contract;
import com.ssid.api.apissid.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ContractServiceImpl extends GenericServiceImpl<Contract> implements ContractService {
    private ContractRepository repository;

    @Autowired
    public ContractServiceImpl(ContractRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contract findByCode(String code) {
        return StringUtils.isEmpty(code) ? null : repository.findByCode(code);
    }


    @Override
    public void saveContract(Contract contract) {
        this.repository.save(contract);
    }
    @Override
    protected JpaRepository<Contract, Long> getRepository() {
        return repository;
    }
}
