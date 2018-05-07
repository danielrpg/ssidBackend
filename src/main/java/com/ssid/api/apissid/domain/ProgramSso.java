package com.ssid.api.apissid.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author daniel fernandez
 */
@Entity
@Table(name = "program_sso")
public class ProgramSso extends ModelBase implements Serializable{

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "sso_id")
    private Long id;

    @Column(name = "sso_objetive", length = 250)
    private String ssoObjetive;

    @Column(name = "sso_indicator", length = 250)
    private String ssoIndicator;

    @Column(name = "sso_goal", length = 250)
    private String ssoGoal;

    @Column(name = "sso_execution_time", length = 250)
    private String ssoExecutionTime;

    @Column(name = "sso_responsable", length = 250)
    private String ssoResponsable;

    @Column(name = "sso_total_cost")
    private Double ssoTotalCost;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programSso", fetch = FetchType.LAZY)
    private Set<ActivitiesSso> activitiesSsos= new HashSet<>();

    public Set<ActivitiesSso> getActivitiesSsos() {
        return activitiesSsos;
    }

    public void setActivitiesSsos(Set<ActivitiesSso> activitiesSsos) {
        this.activitiesSsos = activitiesSsos;
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
}
