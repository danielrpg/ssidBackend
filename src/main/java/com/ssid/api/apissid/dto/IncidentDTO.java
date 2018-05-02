package com.ssid.api.apissid.dto;

public class IncidentDTO {
    private String code;
    private String reportedBy;
    private String area;
    private boolean reincident;
    private boolean treatment;
    private int incidentNumber;
    private String incidentType;
    private String description;

    public IncidentDTO() {}

    public IncidentDTO(String code, String reportedBy, String area, boolean reincident, boolean treatment, int incidentNumber, String incidentType, String description) {
        this.code = code;
        this.reportedBy = reportedBy;
        this.area = area;
        this.reincident = reincident;
        this.treatment = treatment;
        this.incidentNumber = incidentNumber;
        this.incidentType = incidentType;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
