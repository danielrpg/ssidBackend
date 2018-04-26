package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.RiskIpercDetail;
import com.ssid.api.apissid.repositories.RiskIpercDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RiskIpercDetailServiceImpl extends GenericServiceImpl<RiskIpercDetail> implements RiskIpercDetailService {

    private RiskIpercDetailRepository riskIpercDetailRepository;

    @Autowired
    public RiskIpercDetailServiceImpl(RiskIpercDetailRepository riskIpercDetailRepository){
        this.riskIpercDetailRepository = riskIpercDetailRepository;
    }

    @Override
    protected JpaRepository<RiskIpercDetail, Long> getRepository() {
        return riskIpercDetailRepository;
    }
}
