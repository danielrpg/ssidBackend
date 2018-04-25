package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.IncidentDetail;
import com.ssid.api.apissid.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class IncidentDetailServiceImpl implements IncidentDetailService {

    private IncidentRepository incidentRepository;

    @Autowired
    public IncidentDetailServiceImpl(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    @Override
    public List<IncidentDetail> getAllIncidentDetail() {
        return null;
    }
}
