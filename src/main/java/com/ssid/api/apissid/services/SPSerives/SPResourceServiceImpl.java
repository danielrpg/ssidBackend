package com.ssid.api.apissid.services.SPSerives;
import com.ssid.api.apissid.domain.ResourceSso;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class SPResourceServiceImpl implements SPResourceService{

    @PersistenceContext
    private EntityManager entityManager;

 @Override
    public List<ResourceSso> getAllResources() {
        StoredProcedureQuery query =
                entityManager.createNamedStoredProcedureQuery("sp_get_all_program_sso_resources");

        query.execute();

        return (List<ResourceSso>) query.getResultList();
    }

    @Override
    public Boolean deleteResource(Long idResource) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_delete_program_sso_resources");
        query.setParameter("sso_resource_id", idResource);

        query.execute();

        return (Boolean) query.getOutputParameterValue("result");
    }

    @Override
    public Boolean createResource(ResourceSso resourceSso) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_create_program_sso_resource");
        query.setParameter("resource_cost", resourceSso.getResourceCost());
        query.setParameter("resource_detail", resourceSso.getResourceDetail());

        query.execute();

        return (Boolean) query.getOutputParameterValue("result");
    }

    @Override
    public ResourceSso updateResource(Long idResource, ResourceSso resourceSso) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_edit_program_sso_resources");
        query.setParameter("sso_resource_id", idResource);
        query.setParameter("sso_resource_cost", resourceSso.getResourceCost());
        query.setParameter("sso_resource_detail", resourceSso.getResourceDetail());
        query.setParameter("sso_detail_id", resourceSso.getActivitiesSso().getId());

        query.execute();

        return (ResourceSso) query.getSingleResult();
    }

    @Override
    public ResourceSso getResourceById(Long resourceId) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_resourceById");
        query.setParameter("sso_resource_id", resourceId);

        query.execute();

        return (ResourceSso) query.getSingleResult();
    }
}
