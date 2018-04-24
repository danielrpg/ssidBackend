package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class IncidentDetail implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long incidentDetailId;

    @Column
    private String incidentDetailStatus;

    @Column
    private String incidentDetailName;

    @Column
    private String incidentDetailType;

    @Column
    private String incidentDetailSubtype;

    public Long getIncidentDetailId() {
        return incidentDetailId;
    }

    public void setIncidentDetailId(Long incidentDetailId) {
        this.incidentDetailId = incidentDetailId;
    }

    public String getIncidentDetailStatus() {
        return incidentDetailStatus;
    }

    public void setIncidentDetailStatus(String incidentDetailStatus) {
        this.incidentDetailStatus = incidentDetailStatus;
    }

    public String getIncidentDetailName() {
        return incidentDetailName;
    }

    public void setIncidentDetailName(String incidentDetailName) {
        this.incidentDetailName = incidentDetailName;
    }

    public String getIncidentDetailType() {
        return incidentDetailType;
    }

    public void setIncidentDetailType(String incidentDetailType) {
        this.incidentDetailType = incidentDetailType;
    }

    public String getIncidentDetailSubtype() {
        return incidentDetailSubtype;
    }

    public void setIncidentDetailSubtype(String incidentDetailSubtype) {
        this.incidentDetailSubtype = incidentDetailSubtype;
    }
}
