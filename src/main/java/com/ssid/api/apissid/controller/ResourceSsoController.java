package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.ResourceSso;
import com.ssid.api.apissid.domain.UserSystem;
import com.ssid.api.apissid.services.ResourceSsoService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ResourceSsoController {

    private ResourceSsoService resourceSsoService;

    public ResourceSsoController(ResourceSsoService resourceSsoService) {
        this.resourceSsoService = resourceSsoService;
    }


    @RequestMapping(value = ApiPath.RESOURCES_SSO_PATH,method = RequestMethod.GET)
    public List<ResourceSso> getListResources() {
        return resourceSsoService.getResourceSso();
    }

    @RequestMapping(value = ApiPath.RESOURCE_BY_ID, method = RequestMethod.GET)
    public @ResponseBody
    Optional<ResourceSso> findResourceById(@PathVariable(value = "id") Long id){
        return this.resourceSsoService.getResourceById(id);}

    @RequestMapping(value = ApiPath.RESOURCES_SSO_PATH_SAVE, method = RequestMethod.POST)
    public @ResponseBody
    void saveResources(@RequestBody ResourceSso resourceSso) {
        this.resourceSsoService.saveResourceSso(resourceSso);
    }

    @RequestMapping(value = ApiPath.RESOURCES_SSO_PATH_DELETE, method = RequestMethod.DELETE)
    public void deleteResourceById(@PathVariable(value = "id") Long id){
        resourceSsoService.deleteResourceById(id);
    }

    @RequestMapping(value = ApiPath.RESOURCES_SSO_PATH_PUT, method = RequestMethod.PUT)
    public @ResponseBody
    ResourceSso updateResource(@RequestBody ResourceSso resourceSso, @PathVariable(value = "id") Long id) {
        return this.resourceSsoService.updateResource(resourceSso, id);
    }
}