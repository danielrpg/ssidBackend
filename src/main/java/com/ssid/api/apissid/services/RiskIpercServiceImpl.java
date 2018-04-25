package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.RiskIperc;
import com.ssid.api.apissid.repositories.RiskIpercRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RiskIpercServiceImpl implements RiskIpercService {
    private RiskIpercRepository riskIpercRepository;

    @Autowired
    public RiskIpercServiceImpl(RiskIpercRepository riskIpercRepository){
        this.riskIpercRepository = riskIpercRepository;
    }

    @Override
    public List<RiskIperc> getAllRiskIpercs() {
        return riskIpercRepository.findAll();
    }
}
