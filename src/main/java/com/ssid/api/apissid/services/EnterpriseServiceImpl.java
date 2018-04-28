package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Enterprise;
import com.ssid.api.apissid.repositories.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {
    private EnterpriseRepository enterpriseRepository;

    public EnterpriseServiceImpl(EnterpriseRepository enterpriseRepository) {
        this.enterpriseRepository = enterpriseRepository;
    }

    @Override
    public List<Enterprise> getEnterprise() {
        return this.enterpriseRepository.findAll();
    }

    @Override
    public void setEnterprise(Enterprise enterprise) {
        this.enterpriseRepository.save(enterprise);
    }
}
