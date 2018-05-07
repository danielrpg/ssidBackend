package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.ProgramSso;

import java.util.Date;

public class ProgramSsoCommand {
    private Long id;
    private String ssoObjetive;
    private String ssoIndicator;
    private String ssoGoal;
    private String ssoExecutionTime;
    private String ssoResponsable;
    private Double ssoTotalCost;
    private Object[] activitiesSsos = new Object[0];

    public ProgramSsoCommand(){}

    public ProgramSsoCommand(ProgramSso programSso){
        setId(programSso.getId());
        setSsoObjetive(programSso.getSsoObjetive());
        setSsoIndicator(programSso.getSsoIndicator());
        setSsoGoal(programSso.getSsoGoal());
        setSsoExecutionTime(programSso.getSsoExecutionTime());
        setSsoResponsable(programSso.getSsoResponsable());
        setSsoTotalCost(programSso.getSsoTotalCost());
    }

    public ProgramSso toProgramSso(){
        ProgramSso programSso = new ProgramSso();

        programSso.setId(getId());
        programSso.setSsoObjetive(getSsoObjetive());
        programSso.setSsoIndicator(getSsoIndicator());
        programSso.setSsoGoal(getSsoGoal());
        programSso.setSsoExecutionTime(getSsoExecutionTime());
        programSso.setSsoResponsable(getSsoResponsable());
        programSso.setSsoTotalCost(getSsoTotalCost());

        return programSso;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsoObjetive() {
        return ssoObjetive;
    }

    public void setSsoObjetive(String ssoObjetive) {
        this.ssoObjetive = ssoObjetive;
    }

    public String getSsoIndicator() {
        return ssoIndicator;
    }

    public void setSsoIndicator(String ssoIndicator) {
        this.ssoIndicator = ssoIndicator;
    }

    public String getSsoGoal() {
        return ssoGoal;
    }

    public void setSsoGoal(String ssoGoal) {
        this.ssoGoal = ssoGoal;
    }

    public String getSsoExecutionTime() {
        return ssoExecutionTime;
    }

    public void setSsoExecutionTime(String ssoExecutionTime) {
        this.ssoExecutionTime = ssoExecutionTime;
    }

    public String getSsoResponsable() {
        return ssoResponsable;
    }

    public void setSsoResponsable(String ssoResponsable) {
        this.ssoResponsable = ssoResponsable;
    }

    public Double getSsoTotalCost() {
        return ssoTotalCost;
    }

    public void setSsoTotalCost(Double ssoTotalCost) {
        this.ssoTotalCost = ssoTotalCost;
    }

    public Object[] getActivitiesSsos() {
        return activitiesSsos;
    }

    public void setActivitiesSsos(Object[] activitiesSsos) {
        this.activitiesSsos = activitiesSsos;
    }
}
