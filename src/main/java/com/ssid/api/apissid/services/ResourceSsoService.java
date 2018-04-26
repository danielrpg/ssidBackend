package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.ResourceSso;

import java.util.List;
import java.util.Optional;

public interface ResourceSsoService {
    List<ResourceSso> getResourceSso();
    void saveResourceSso(ResourceSso resourceSso);
    Optional<ResourceSso> getResourceById(Long id);
    void deleteResourceById(Long id);
    ResourceSso updateResource(ResourceSso resourceSso, Long id);
}
