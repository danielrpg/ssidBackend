package com.ssid.api.apissid.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
/**
 * @author christian Tola
 */
@Entity
public class IncidentDetail extends ModelBaseAudit implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incidentDetailId;

    @Column
    private String incidentDetailStatus;

    @Column
    private String incidentDetailName;

    @Column
    private String incidentDetailDescription;

    @OneToOne(mappedBy = "incidentDetail", fetch = FetchType.LAZY)
    @JsonIgnore
    private Incident incident;

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

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public String getIncidentDetailDescription() {
        return incidentDetailDescription;
    }

    public void setIncidentDetailDescription(String incidentDetailDescription) {
        this.incidentDetailDescription = incidentDetailDescription;
    }
}
