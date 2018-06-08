package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.Incident;

public interface SPIncidentService {

    Boolean createIncident(Long incidentDetailId, Long incidentTypeId, Long personalId, Incident incident);
}
