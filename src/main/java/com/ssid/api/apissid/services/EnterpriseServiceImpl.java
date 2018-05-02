package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Enterprise;
import com.ssid.api.apissid.repositories.EnterpriseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseServiceImpl extends GenericServiceImpl<Enterprise> implements EnterpriseService {
    private EnterpriseRepository enterpriseRepository;

    public EnterpriseServiceImpl(EnterpriseRepository enterpriseRepository) {
        this.enterpriseRepository = enterpriseRepository;
    }

    @Override
    protected JpaRepository<Enterprise, Long> getRepository() {
        return this.getRepository();
    }
}
