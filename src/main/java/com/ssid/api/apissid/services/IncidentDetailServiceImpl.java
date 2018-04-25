package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.IncidentDetail;
import com.ssid.api.apissid.repositories.IncidentDetailRepository;
import com.ssid.api.apissid.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IncidentDetailServiceImpl implements IncidentDetailService {

    private IncidentDetailRepository incidentDetailRepository;

    @Autowired
    public IncidentDetailServiceImpl(IncidentDetailRepository incidentDetailRepository) {
        this.incidentDetailRepository = incidentDetailRepository;
    }

    @Override
    public List<IncidentDetail> getAllIncidentDetail() {
        return this.incidentDetailRepository.findAll();
    }
}
