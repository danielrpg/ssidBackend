package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.Area;
import com.ssid.api.apissid.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Long>{
    Contract findByCode(String name);
}
