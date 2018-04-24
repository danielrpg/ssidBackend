package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Incident implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long incidentId;

    @Column
    private String code;

    @Column
    private Date dateAt;

    @Column
    private String reportedBy;

    @Column
    private String area;

    @Column
    private boolean reincident;

    @Column
    private boolean treatment;

    @Column
    private int incidentNumber;

    public Long getId() {
        return incidentId;
    }

    public void setId(Long incidentId) {
        this.incidentId = incidentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDateAt() {
        return dateAt;
    }

    public void setDateAt(Date dateAt) {
        this.dateAt = dateAt;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isReincident() {
        return reincident;
    }

    public void setReincident(boolean reincident) {
        this.reincident = reincident;
    }

    public boolean isTreatment() {
        return treatment;
    }

    public void setTreatment(boolean treatment) {
        this.treatment = treatment;
    }

    public int getIncidentNumber() {
        return incidentNumber;
    }

    public void setIncidentNumber(int incidentNumber) {
        this.incidentNumber = incidentNumber;
    }
}
