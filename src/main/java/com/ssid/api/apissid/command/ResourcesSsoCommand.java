package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.ResourceSso;


public class ResourcesSsoCommand {
    private Long id;
    private float resourceCost;
    private String resourceDetail;

    public ResourcesSsoCommand(){}

    public ResourcesSsoCommand(ResourceSso resourceSso){
        setId(resourceSso.getId());
        setSsoCost(resourceSso.getResourceCost());
        setSsoDetail(resourceSso.getResourceDetail());
    }

    public ResourceSso toResourcesSso(){
        ResourceSso resourcesSso = new ResourceSso();
        resourcesSso.setId(getId());
        resourcesSso.setResourceCost(getSsoCost());
        resourcesSso.setResourceDetail(getSsoDetail());



        return resourcesSso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public float getSsoCost() {
        return resourceCost;
    }

    public void setSsoCost(float ssoCost) {
        this.resourceCost = ssoCost;
    }

    public String getSsoDetail() {
        return resourceDetail;
    }

    public void setSsoDetail(String resourceDetail) {
        this.resourceDetail = resourceDetail;
    }

}


