package com.ssid.api.apissid.domain;

import javax.persistence.*;

/**
 * @author daniel fernandez
 */
@Entity
@Table(name = "program_sso")
public class ProgramSso {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "sso_id")
    private Long id;

    @Column(name = "sso_objetive", length = 50,unique = true)
    private String ssoObjetive;

    @Column(name = "sso_indicator", length = 50,unique = true)
    private String ssoIndicator;

    @Column(name = "sso_goal", length = 50,unique = true)
    private String ssoGoal;

    @Column(name = "sso_execution_time", length = 50,unique = true)
    private String ssoExecutionTime;

    @Column(name = "sso_responsable", length = 50,unique = true)
    private String ssoResponsable;

    @Column(name = "sso_total_cost", length = 50,unique = true)
    private Double ssoTotalCost;

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
