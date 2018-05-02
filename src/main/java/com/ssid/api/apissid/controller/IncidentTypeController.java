package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncidentTypeController {

    @RequestMapping(path = ApiPath.INCIDENT_TYPE_PATH, method = RequestMethod.GET)
    private String getIncidentsType(){
        String res ="List Incident Type";
        return res;
    }
}
