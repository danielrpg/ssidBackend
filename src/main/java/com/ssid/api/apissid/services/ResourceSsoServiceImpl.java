package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.ResourceSso;
import com.ssid.api.apissid.repositories.ResourceSsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<ResourceSso> getResourceById(Long id) {
        return resourceSsoRepository.findById(id);
    }

    @Override
    public void deleteResourceById(Long id) {
        Optional<ResourceSso> resourceSso = this.resourceSsoRepository.findById(id);
        this.resourceSsoRepository.delete(resourceSso.get());
    }

    @Override
    public ResourceSso updateResource(ResourceSso resourceSso, Long id) {
        Optional<ResourceSso> updateResource = this.resourceSsoRepository.findById(id);
        if(!updateResource.isPresent())
            return null;
        resourceSso.setId(id);
        this.resourceSsoRepository.save(resourceSso);
        return resourceSso;
    }
}
