package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Incident;
import com.ssid.api.apissid.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IncidentServiceImpl implements IncidentService {

    private IncidentRepository incidentRepository;

    @Autowired
    public IncidentServiceImpl(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    @Override
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }
}
