package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.RiskIpercDetail;
import com.ssid.api.apissid.repositories.RiskIpercDetailRepository;
import com.ssid.api.apissid.repositories.RiskIpercRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RiskIpercDetailServiceImpl implements RiskIpercDetailService {

    private RiskIpercDetailRepository riskIpercDetailRepository;

    @Autowired
    public RiskIpercDetailServiceImpl(RiskIpercDetailRepository riskIpercDetailRepository){
        this.riskIpercDetailRepository = riskIpercDetailRepository;
    }

    @Override
    public List<RiskIpercDetail> getAllRiskIpercDetails() {
        return riskIpercDetailRepository.findAll();
    }
}
