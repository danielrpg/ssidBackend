package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.ResourceSso;


public class ResourcesSsoCommand {
    private Long resourceId;
    private Double resourceCost;
    private String resourceDetail;
    private Object[] activitiesSsos = new Object[0];

    public ResourcesSsoCommand(ResourceSso resourceSso){
        setId(resourceSso.getId());
        setSsoCost(resourceSso.getResourceCost());
        setSsoDetail(resourceSso.getResourceDetail());
    }

    public ResourceSso toResourcesSso(){
        ResourceSso resourcesSso = new ResourceSso();
        resourcesSso.setId(getId());
        resourcesSso.setResourceDetail(getSsoDetail());
        resourcesSso.setResourceCost(getSsoCost());

        return resourcesSso;
    }

    public Long getId() {
        return resourceId;
    }

    public void setId(Long resourceId) {
        this.resourceId = resourceId;
    }


    public Double getSsoCost() {
        return resourceCost;
    }

    public void setSsoCost(Double ssoCost) {
        this.resourceCost = ssoCost;
    }

    public String getSsoDetail() {
        return resourceDetail;
    }

    public void setSsoDetail(String resourceDetail) {
        this.resourceDetail = resourceDetail;
    }

    public Object[] getActivitiesSsos() {
        return activitiesSsos;
    }

    public void setActivitiesSsos(Object[] activitiesSsos) {
        this.activitiesSsos = activitiesSsos;
    }
}


