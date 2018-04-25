package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.ResourceSso;
import com.ssid.api.apissid.repositories.ResourceSsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceSsoServiceImpl implements ResourceSsoService {
    private ResourceSsoRepository resourceSsoRepository;

    public ResourceSsoServiceImpl(ResourceSsoRepository resourceSsoRepository) {
        this.resourceSsoRepository = resourceSsoRepository;
    }

    @Override
    public List<ResourceSso> getResourceSso() {
        return this.resourceSsoRepository.findAll();
    }

    @Override
    public void saveResourceSso(ResourceSso resourceSso) {
        this.resourceSsoRepository.save(resourceSso);
    }
}
