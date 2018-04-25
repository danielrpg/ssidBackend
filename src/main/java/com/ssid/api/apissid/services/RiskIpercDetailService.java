package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.RiskIperc;
import com.ssid.api.apissid.domain.RiskIpercDetail;

import java.util.List;

public interface RiskIpercDetailService  {
    List<RiskIpercDetail> getAllRiskIpercDetails();
    void saveRiskIpercDetail(RiskIpercDetail riskIpercDetail);
    void updateRiskIpercDetail(RiskIperc riskIperc);
    void deleteRiskIpercDetail(Long id);
    void getRiskIpercDetail(Long id);
}
