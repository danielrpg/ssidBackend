package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.IncidentType;
import com.ssid.api.apissid.services.IncidentTypeService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IncidentTypeController {
    private IncidentTypeService incidentTypeService;

    public IncidentTypeController(IncidentTypeService incidentTypeService) {
        this.incidentTypeService = incidentTypeService;
    }
    @GetMapping(path = ApiPath.INCIDENT_TYPE_PATH)
    public List<IncidentType> getListIncidentType(){
        return this.incidentTypeService.getListIncidentType();
    }
}
