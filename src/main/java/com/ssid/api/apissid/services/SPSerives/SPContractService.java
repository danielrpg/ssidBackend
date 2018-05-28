package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.Contract;

import java.util.List;

public interface SPContractService {

    List<Contract> getAllContracts();

    Boolean createContract(Contract contract);

    Boolean deleteContract(Long idContract);

    Contract updateContract(Long idContract, Contract contract);
}
