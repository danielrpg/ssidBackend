package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.IncidentType;
import com.ssid.api.apissid.repositories.IncidentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentTypeServiceImpl implements IncidentTypeService {
    private IncidentTypeRepository incidentTypeRepository;

    public IncidentTypeServiceImpl(IncidentTypeRepository incidentTypeRepository) {
        this.incidentTypeRepository = incidentTypeRepository;
    }

    @Override
    public List<IncidentType> getListIncidentType() {
        return this.incidentTypeRepository.findAll();
    }
}
