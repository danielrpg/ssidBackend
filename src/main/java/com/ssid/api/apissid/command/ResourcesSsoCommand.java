package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.ResourceSso;

import java.util.Date;

public class ResourcesSsoCommand {
    private Long id;
    private Date ssoCreatedOn;
    private Date ssoUpdatedOn;
    private Long ssoVersion;
    private Double ssoCost;
    private String ssoDetail;
    private Object[] activitiesSsos = new Object[0];

    public ResourcesSsoCommand(){}

    public ResourcesSsoCommand(ResourceSso resourceSso){
        setId(resourceSso.getId());
        setSsoCreatedOn(resourceSso.getResourceCreatedOn());
        setSsoUpdatedOn(resourceSso.getResourceUpdatedOn());
        setSsoVersion(resourceSso.getVersion());
        setSsoCost(resourceSso.getResourceCost());
        setSsoDetail(resourceSso.getResourceDetail());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSsoCreatedOn() {
        return ssoCreatedOn;
    }

    public void setSsoCreatedOn(Date ssoCreatedOn) {
        this.ssoCreatedOn = ssoCreatedOn;
    }

    public Date getSsoUpdatedOn() {
        return ssoUpdatedOn;
    }

    public void setSsoUpdatedOn(Date ssoUpdatedOn) {this.ssoUpdatedOn = ssoUpdatedOn; }

    public long getSsoVersion() {return ssoVersion;}

    public void setSsoVersion(long ssoVersion) {
        this.ssoVersion = ssoVersion;
    }

    public Double getSsoCost() {
        return ssoCost;
    }

    public void setSsoCost(Double ssoExecutionTime) {
        this.ssoCost = ssoCost;
    }

    public String getSsoDetail() {
        return ssoDetail;
    }

    public void setSsoDetail(String ssoDetail) {
        this.ssoDetail = ssoDetail;
    }

    public Object[] getActivitiesSsos() {
        return activitiesSsos;
    }

    public void setActivitiesSsos(Object[] activitiesSsos) {
        this.activitiesSsos = activitiesSsos;
    }
}


