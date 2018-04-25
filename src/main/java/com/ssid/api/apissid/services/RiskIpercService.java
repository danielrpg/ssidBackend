package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.RiskIperc;
import com.ssid.api.apissid.domain.RiskIpercDetail;

import java.util.List;

public interface RiskIpercService {
    List<RiskIperc> getAllRiskIpercs();
    void saveRiskIperc(RiskIperc riskIperc);
    void updateRiskIperc(RiskIperc riskIperc);
    void deleteRiskIperc(Long id);
    void getRiskIperc(Long id);
}
