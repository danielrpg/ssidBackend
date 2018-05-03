package com.ssid.api.apissid.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
/**
 * @author christian Tola
 */
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

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }
}
