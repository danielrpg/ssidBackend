package com.ssid.api.apissid.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author christian Tola
 */
@Entity
public class IncidentType extends ModelBaseAudit implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incidentTypeId;

    @Column
    private String incidentTypeName;

    @Column
    private String incidentTypeDescription;

    @Column(name = "incident_type_type")
    private String incidentType;

    @Column(name = "incident_type_subtype")
    private String incidentSubType;

    @OneToMany(mappedBy = "incidentType", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Incident> incident = new ArrayList<>();

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

    public List<Incident> getIncident() {
        return incident;
    }

    public void setIncident(List<Incident> incident) {
        this.incident = incident;
    }
}
