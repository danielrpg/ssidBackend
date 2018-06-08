
package com.ssid.api.apissid.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ssid.api.apissid.command.ActivitySsoCommand;
import com.ssid.api.apissid.domain.ActivitiesSso;
import com.ssid.api.apissid.services.ActivitiesSsoService;
import com.ssid.api.apissid.services.SPSerives.SPActivityService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = ApiPath.ACTIVITIES_SSO_PATH)
public class ActivitiesSsoController {
    private ActivitiesSsoService activitiesSsoService;
    private SPActivityService spActivityService;

    @Autowired
    public ActivitiesSsoController(ActivitiesSsoService activitiesSsoService, SPActivityService spActivityService) {
        this.activitiesSsoService = activitiesSsoService;
        this.spActivityService = spActivityService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getListActivitiesSso() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<ActivitySsoCommand> activitiesList = new ArrayList<>();
        this.activitiesSsoService.getActivitiesSso().forEach(activitiesSso -> {
            activitiesList.add(new ActivitySsoCommand(activitiesSso));
        });
        mapResponse.put("data", activitiesList);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> findActivitiesById(@PathVariable Long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        ActivitiesSso activitiesSso = this.activitiesSsoService.getActivityById(id);



        if (activitiesSso != null) {
            mapResponse.put("status", "ok");
            mapResponse.put("data", new ActivitySsoCommand(activitiesSso));
            return new ResponseEntity<>(mapResponse, HttpStatus.OK);
        } else {
            mapResponse.put("status", "not found");
            mapResponse.put("data", null);
            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> saveActivitySso(@RequestBody ActivitySsoCommand activitySsoCommand) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "created");
        mapResponse.put("data", activitiesSsoService.saveActivitiesSso(activitySsoCommand.toActivitiesSso()));
        return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateActivitySso(@RequestBody ActivitySsoCommand activitySsoCommand, @PathVariable int id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "updated");
        mapResponse.put("data", activitiesSsoService.updateActivity(activitySsoCommand.toActivitiesSso(), (long) id));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteActivitySsoById(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "deleted");
        this.activitiesSsoService.deleteActivityById(id);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

   @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> saveActivity(@RequestBody ActivitiesSso activity){
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("success", this.spActivityService.createActivity(activity));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/getActivityById/{id}", method = RequestMethod.GET)
    public ActivitiesSso getActivityById(@PathVariable Long id) throws JsonProcessingException {
        return spActivityService.getActivityById(id);
    }

    @RequestMapping( value = "/update/{id}", method = RequestMethod.PUT)
    public ActivitiesSso updateActivity(@RequestBody ActivitiesSso activitiesSso, @PathVariable Long id) {
        return  this.spActivityService.updateActivity(id, activitiesSso);
    }

    @RequestMapping( value = {"/activityList"}, method = RequestMethod.GET)
    public List<ActivitiesSso> listActivities(){
        return this.spActivityService.getAllActivities();
    }


    /*@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteActivity(@PathVariable Long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "deleted");
        this.spActivityService.deleteActivity(id);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }*/
}
