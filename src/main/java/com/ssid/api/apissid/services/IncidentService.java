package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Incident;
import com.ssid.api.apissid.dto.IncidentDTO;

import java.util.List;

public interface IncidentService {
    Incident getIncidentById(int id);
    List<Incident> getAllIncidents();
    Incident createIncident(IncidentDTO incidentDTO);
    boolean updateIncident(IncidentDTO incidentDTO, int id);
    void deleteIncident(int id);
}
