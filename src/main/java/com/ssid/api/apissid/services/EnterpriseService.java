package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Enterprise;

import java.util.List;

public interface EnterpriseService {
    List<Enterprise> getEnterprise();

    void setEnterprise(Enterprise enterprise);
}

