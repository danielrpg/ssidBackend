package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.ResourceSso;
import com.ssid.api.apissid.exceptions.NotFoundException;
import com.ssid.api.apissid.repositories.ResourceSsoRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@Service
public class ResourceSsoServiceImpl implements ResourceSsoService {
    private ResourceSsoRepository resourceSsoRepository;

    public ResourceSsoServiceImpl(ResourceSsoRepository resourceSsoRepository) {
        this.resourceSsoRepository = resourceSsoRepository;
    }

    @Override
    public List<ResourceSso> getResource() {return this.resourceSsoRepository.findAll();
    }

    @Override
    public ResourceSso saveResourceSso(ResourceSso resourceSso) {
        return resourceSsoRepository.save(resourceSso);
    }

    @Override
    public ResourceSso getResourceById(Long id) {
        Optional<ResourceSso> optional = resourceSsoRepository.findById(id);
        if (!optional.isPresent()) {
            String typeName = (((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
            typeName = typeName.substring(typeName.lastIndexOf(".") + 1);
            throw new NotFoundException(typeName + " id:" + id + " Not Found");
        }
        return optional.get();
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
