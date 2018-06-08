package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.ResourceSso;

import java.util.List;

public interface SPResourceService {

   List<ResourceSso> getAllResources();

    Boolean deleteResource(Long idActivity);

    Boolean createResource(ResourceSso resourceSso);

    ResourceSso updateResource(Long resourceId, ResourceSso resourceSso);

    ResourceSso getResourceById(Long resourceId);
}
