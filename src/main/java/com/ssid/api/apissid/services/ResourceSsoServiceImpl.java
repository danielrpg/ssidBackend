package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.ActivitiesSso;
import com.ssid.api.apissid.domain.ResourceSso;
import com.ssid.api.apissid.exceptions.NotFoundException;
import com.ssid.api.apissid.repositories.ActivitiesSsoRepository;
import com.ssid.api.apissid.repositories.ResourceSsoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@Service
public class ResourceSsoServiceImpl implements ResourceSsoService {
    private static Logger logger = LoggerFactory.getLogger(ResourceSsoServiceImpl.class);
    private ResourceSsoRepository resourceSsoRepository;
    private ActivitiesSsoRepository activitiesSsoRepository;

    @Autowired
    public ResourceSsoServiceImpl(ResourceSsoRepository resourceSsoRepository,
                                  ActivitiesSsoRepository activitiesSsoRepository) {
        this.resourceSsoRepository = resourceSsoRepository;
        this.activitiesSsoRepository = activitiesSsoRepository;
    }

    @Override
    public List<ResourceSso> getResource() {
        return this.resourceSsoRepository.findAll();
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
        resourceSsoRepository.deleteById(id);
    }

    @Override
    public ResourceSso updateResourceSso(ResourceSso resourceSso, Long id) {
        Optional<ResourceSso> resourceSsoUpdate = this.resourceSsoRepository.findById(id);
        if (!resourceSsoUpdate.isPresent())
            return null;
        resourceSso.setId(id);
        this.resourceSsoRepository.save(resourceSso);
        return resourceSso;
    }


}
