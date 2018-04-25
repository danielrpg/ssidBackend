package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Incident;

import java.util.List;

public interface IncidentService {
    List<Incident> getAllIncidents();
}
