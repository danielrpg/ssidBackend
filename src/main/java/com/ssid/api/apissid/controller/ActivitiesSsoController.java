package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.ActivitiesSso;
import com.ssid.api.apissid.domain.ResourceSso;
import com.ssid.api.apissid.services.ActivitiesSsoService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ActivitiesSsoController {

    private ActivitiesSsoService activitiesSsoService;

    public ActivitiesSsoController(ActivitiesSsoService activitiesSsoService) {
        this.activitiesSsoService = activitiesSsoService;
    }


    @RequestMapping(value = ApiPath.ACTIVITIES_SSO_PATH, method = RequestMethod.GET)
    public List<ActivitiesSso> getListActivities() {
        return activitiesSsoService.getActivitiesSso();
    }


    @RequestMapping(value = ApiPath.ACTIVITIES_SSO_PATH_SAVE, method = RequestMethod.POST)
    public @ResponseBody
    void saveActivities(@RequestBody ActivitiesSso activitiesSso) {
        this.activitiesSsoService.saveActivitiesSso(activitiesSso);
    }

    @RequestMapping(value = ApiPath.ACTIVITIES_BY_ID, method = RequestMethod.GET)
    public @ResponseBody
    Optional<ActivitiesSso> findActivitieById(@PathVariable(value = "id") Long id){
        return this.activitiesSsoService.getActivitieById(id);
    }

    @RequestMapping(value = ApiPath.ACTIVITIES_SSO_PATH_DELETE, method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteActivitieById(@PathVariable(value = "id") Long id){
        this.activitiesSsoService.deleteActivitieById(id);

    }

    @RequestMapping(value = ApiPath.ACTIVITIES_SSO_PATH_PUT, method = RequestMethod.PUT)
    public @ResponseBody
    ActivitiesSso updateActivitie(@RequestBody ActivitiesSso activitiesSso, @PathVariable(value = "id") Long id){
        return this.activitiesSsoService.updateActivitie(activitiesSso, id);
    }
}
