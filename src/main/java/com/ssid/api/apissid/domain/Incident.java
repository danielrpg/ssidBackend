package com.ssid.api.apissid.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.*;

/**
 * @author christian Tola
 */
@Entity
public class Incident extends ModelBaseAudit implements Serializable {

    @Id
    @Column(name = "incident_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incidentId;

    @Column
    private String incidentCode;

    @Column
    private Date incidentRegisteredDate;

    @Column
    private String incidentReportedBy;

//    @Column
//    private String area;

    @Column
    private boolean incidentReincident;

    @Column
    private boolean incidentTreatment;

    @Column
    private int incidentNumber;

//    @Column
//    private int recurrence;

    @Column
    private String incidentSeverity;

//    @ManyToMany(mappedBy = "incidents", fetch = FetchType.LAZY)
//    private Set<RiskIpercDetail> riskIpercDetails;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "incident_type_id")
    private IncidentType incidentType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "incident_detail_id")
    private IncidentDetail incidentDetail;

    @ManyToOne
    @JoinColumn(name = "personal_id")
    private Personal personal;

    public Long getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(Long incidentId) {
        this.incidentId = incidentId;
    }

    public String getIncidentCode() {
        return incidentCode;
    }

    public void setIncidentCode(String incidentCode) {
        this.incidentCode = incidentCode;
    }

    public Date getIncidentRegisteredDate() {
        return incidentRegisteredDate;
    }

    public void setIncidentRegisteredDate(Date incidentRegisteredDate) {
        this.incidentRegisteredDate = incidentRegisteredDate;
    }

    public String getIncidentReportedBy() {
        return incidentReportedBy;
    }

    public void setIncidentReportedBy(String incidentReportedBy) {
        this.incidentReportedBy = incidentReportedBy;
    }

    public boolean isIncidentReincident() {
        return incidentReincident;
    }

    public void setIncidentReincident(boolean incidentReincident) {
        this.incidentReincident = incidentReincident;
    }

    public boolean isIncidentTreatment() {
        return incidentTreatment;
    }

    public void setIncidentTreatment(boolean incidentTreatment) {
        this.incidentTreatment = incidentTreatment;
    }

    public int getIncidentNumber() {
        return incidentNumber;
    }

    public void setIncidentNumber(int incidentNumber) {
        this.incidentNumber = incidentNumber;
    }

    public String getIncidentSeverity() {
        return incidentSeverity;
    }

    public void setIncidentSeverity(String incidentSeverity) {
        this.incidentSeverity = incidentSeverity;
    }

    public IncidentType getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(IncidentType incidentType) {
        this.incidentType = incidentType;
    }

    public IncidentDetail getIncidentDetail() {
        return incidentDetail;
    }

    public void setIncidentDetail(IncidentDetail incidentDetail) {
        this.incidentDetail = incidentDetail;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
}
