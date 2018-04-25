package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.ActivitiesSso;
import com.ssid.api.apissid.services.ActivitiesSsoService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivitiesSsoController {

    private ActivitiesSsoService activitiesSsoService;

    public ActivitiesSsoController(ActivitiesSsoService activitiesSsoService) {
        this.activitiesSsoService = activitiesSsoService;
    }


    @GetMapping(path = ApiPath.ACTIVITIES_SSO_PATH)
    public List<ActivitiesSso> getListActivities() {
        return this.activitiesSsoService.getActivitiesSso();
    }

    @RequestMapping(value = ApiPath.ACTIVITIES_SSO_PATH, method = RequestMethod.POST)
    public @ResponseBody
    void saveActivities(@RequestBody ActivitiesSso activitiesSso) {
        this.activitiesSsoService.saveActivitiesSso(activitiesSso);
    }
}
