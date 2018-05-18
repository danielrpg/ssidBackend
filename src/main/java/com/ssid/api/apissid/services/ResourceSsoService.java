package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.ResourceSso;

import java.util.List;

public interface ResourceSsoService {
    List<ResourceSso> getResource();
    ResourceSso saveResourceSso(ResourceSso resourceSso);
    ResourceSso getResourceById(Long id);
    void deleteResourceById(Long id);
    ResourceSso updateResourceSso(ResourceSso resourceSso, Long id);
}
