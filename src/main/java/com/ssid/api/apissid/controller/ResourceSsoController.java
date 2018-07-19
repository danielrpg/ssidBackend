
package com.ssid.api.apissid.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.ssid.api.apissid.command.ResourcesSsoCommand;
import com.ssid.api.apissid.domain.ActivitiesSso;
import com.ssid.api.apissid.domain.ResourceSso;
import com.ssid.api.apissid.services.ResourceSsoService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ssid.api.apissid.services.SPSerives.SPResourceService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = ApiPath.RESOURCES_SSO_PATH)
public class ResourceSsoController {
    private ResourceSsoService resourceSsoService;
    private SPResourceService spResourceService;

    @Autowired
    public ResourceSsoController(ResourceSsoService resourceSsoService, SPResourceService spResourceService) {
        this.resourceSsoService = resourceSsoService;
        this.spResourceService = spResourceService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getListResourcesSso() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<ResourceSso> resourcesList = resourceSsoService.getResource();
        mapResponse.put("data", resourcesList);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> findResourcesSsoById(@PathVariable Long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        ResourceSso resourceSso = this.resourceSsoService.getResourceById(id);
        mapResponse.put("data", resourceSso);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);

    }

   /* @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> saveResourceSso(@RequestBody ResourcesSsoCommand resourcesSsoCommand) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "created");
        mapResponse.put("data", resourceSsoService.saveResourceSso(resourcesSsoCommand.toResourcesSso()));
        return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);
    }*/
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateResourceSso(@RequestBody ResourcesSsoCommand resourcesSsoCommand, @PathVariable Long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "updated");
        mapResponse.put("data", resourceSsoService.updateResourceSso(resourcesSsoCommand.toResourcesSso(), id));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteResourceSsoById(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "deleted");
        this.resourceSsoService.deleteResourceById(id);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> saveResourceSso(@RequestBody ResourcesSsoCommand resourcesSsoCommand) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("success", this.spResourceService.createResource(resourcesSsoCommand.toResourcesSso()));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/getResourceById/{id}", method = RequestMethod.GET)
    public ResourceSso getResourceSSOById(@PathVariable Long id) throws JsonProcessingException {
        return spResourceService.getResourceById(id);
    }

    @RequestMapping( value = "/updateSSO/{id}", method = RequestMethod.PUT)
    public ResourceSso updateResourceSSO(@RequestBody ResourceSso resourceSso, @PathVariable Long id) {
        return  this.spResourceService.updateResource(id, resourceSso);
    }

    @RequestMapping( value = {"/resourceList"}, method = RequestMethod.GET)
    public List<ResourceSso> listResources(){
        return this.spResourceService.getAllResources();
    }


    /*@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteResource(@PathVariable Long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "deleted");
        this.spResourceService.deleteResource(id);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }*/
}
