package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.ResourceSso;


public class ResourcesSsoCommand {
    private Long id;
    private float resourceCost;
    private String resourceDetail;


//    public ResourcesSsoCommand(ResourceSso resourceSso){
//        setId(resourceSso.getId());
//        setResourceCost(resourceSso.getResourceCost());
//        setResourceDetail(resourceSso.getResourceDetail());
//    }

    public ResourceSso toResourcesSso(){
        ResourceSso resourcesSso = new ResourceSso();
        resourcesSso.setId(getId());
        resourcesSso.setResourceCost(getResourceCost());
        resourcesSso.setResourceDetail(getResourceDetail());



        return resourcesSso;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getResourceCost() {
        return resourceCost;
    }

    public void setResourceCost(float resourceCost) {
        this.resourceCost = resourceCost;
    }

    public String getResourceDetail() {
        return resourceDetail;
    }

    public void setResourceDetail(String resourceDetail) {
        this.resourceDetail = resourceDetail;
    }
}


