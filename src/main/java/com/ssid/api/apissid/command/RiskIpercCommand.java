package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.RiskIperc;

import java.util.Date;

public class RiskIpercCommand {
    private Long id;
    private String goal;
    private String area;
    private String responsable;
    private String date;
    private EnterpriseCommand enterprise;
    private Object[] riskIpercDetails = new Object[0];

    public RiskIpercCommand(){}

    public RiskIpercCommand(RiskIperc riskIperc){
        setId(riskIperc.getId());
        setGoal(riskIperc.getGoal());
        setArea(riskIperc.getArea());
        setResponsable(riskIperc.getResponsable());
        setDate(riskIperc.getDate().toString());

    }

    public RiskIperc toRiskIperc(){
        RiskIperc riskIperc = new RiskIperc();
        riskIperc.setId(getId());
        riskIperc.setGoal(getGoal());
        riskIperc.setArea(getArea());
        riskIperc.setResponsable(getResponsable());
        riskIperc.setDate(new Date(getDate()));

        return riskIperc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public EnterpriseCommand getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(EnterpriseCommand enterprise) {
        this.enterprise = enterprise;
    }

    public Object[] getRiskIpercDetails() {
        return riskIpercDetails;
    }

    public void setRiskIpercDetails(Object[] riskIpercDetails) {
        this.riskIpercDetails = riskIpercDetails;
    }
}
