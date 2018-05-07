package com.ssid.api.apissid.dto;

public class IncidentDTO {
    private String code;
    private String reportedBy;
    private String area;
    private boolean reincident;
    private boolean treatment;
    private int incidentNumber;
    private String incidentTypeName;
    private String description;
    private String incidentSubType;
    private String status;
    private int recurrence;
    private String severity;

    public IncidentDTO() {}

    public IncidentDTO(String code, String reportedBy, String area, boolean reincident, boolean treatment, int incidentNumber, String incidentTypeName, String description, String incidentSubType, String status, int recurrence, String severity) {
        this.code = code;
        this.reportedBy = reportedBy;
        this.area = area;
        this.reincident = reincident;
        this.treatment = treatment;
        this.incidentNumber = incidentNumber;
        this.incidentTypeName = incidentTypeName;
        this.description = description;
        this.incidentSubType = incidentSubType;
        this.status = status;
        this.recurrence = recurrence;
        this.severity = severity;
    }

    public String getIncidentTypeName() {
        return incidentTypeName;
    }

    public void setIncidentTypeName(String incidentTypeName) {
        this.incidentTypeName = incidentTypeName;
    }

    public String getIncidentSubType() {
        return incidentSubType;
    }

    public void setIncidentSubType(String incidentSubType) {
        this.incidentSubType = incidentSubType;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(int recurrence) {
        this.recurrence = recurrence;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}
