package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Contract;

import java.util.List;

public interface ContractService extends GenericService<Contract> {
    Contract findByCode(String code);
    void saveContract(Contract contract);
}
