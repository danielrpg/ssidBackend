package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.Incident;
import com.ssid.api.apissid.dto.IncidentDTO;
import com.ssid.api.apissid.services.IncidentDetailService;
import com.ssid.api.apissid.services.IncidentService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = ApiPath.INCIDENT_PATH)
public class IncidentController {

    private IncidentService incidentService;

    @Autowired
    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllIncidents() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<Incident> incidents = incidentService.getAllIncidents();
        mapResponse.put("data", incidents);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getIncidentById(@PathVariable int id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        Incident incident = incidentService.getIncidentById(id);
        mapResponse.put("data", incident);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> createNewIncident( @RequestBody IncidentDTO incidentDTO) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "created");
        Incident incident = incidentService.createIncident(incidentDTO);
        mapResponse.put("data", incident);
        return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateIncident(@RequestBody IncidentDTO incidentDTO, @PathVariable int id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "updated");
        boolean res = incidentService.updateIncident(incidentDTO, id);
        mapResponse.put("data", res);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteIncident(@PathVariable int id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "deleted");
        incidentService.deleteIncident(id);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}
