package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.ResourceSso;

import java.util.List;

public interface ResourceSsoService {
    List<ResourceSso> getResourceSso();
    void saveResourceSso(ResourceSso resourceSso);
}
