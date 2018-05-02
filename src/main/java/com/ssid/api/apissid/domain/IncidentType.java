package com.ssid.api.apissid.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author christian Tola
 */
@Entity
public class IncidentType implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long incidentTypeId;

    @Column
    private String incidentTypeName;

    @Column
    private String incidentTypeDescription;

    @Column
    private String incidentType;

    @Column
    private String incidentSubType;

    @OneToOne(mappedBy = "incidentType", fetch = FetchType.LAZY)
    @JsonIgnore
    private Incident incident;

    public Long getIncidentTypeId() {
        return incidentTypeId;
    }

    public void setIncidentTypeId(Long incidentTypeId) {
        this.incidentTypeId = incidentTypeId;
    }

    public String getIncidentTypeName() {
        return incidentTypeName;
    }

    public void setIncidentTypeName(String incidentTypeName) {
        this.incidentTypeName = incidentTypeName;
    }

    public String getIncidentTypeDescription() {
        return incidentTypeDescription;
    }

    public void setIncidentTypeDescription(String incidentTypeDescription) {
        this.incidentTypeDescription = incidentTypeDescription;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public String getIncidentSubType() {
        return incidentSubType;
    }

    public void setIncidentSubType(String incidentSubType) {
        this.incidentSubType = incidentSubType;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }
}
