package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Marcos Bustos Jimenez
 */

@Entity
@Table(name = "risk_iperc_detail")
public class RiskIpercDetail extends ModelBase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "risk_iperc_det_id")
    private Long id;
    @Column(name = "risk_iperc_det_ide_acti", length = 50)
    private String activity;
    @Column(name = "risk_iperc_det_ide_cond", length = 50)
    private String condition;
    @Column(name = "risk_iperc_det_ide_act", length = 50)
    private String act;
    @Column(name = "risk_iperc_det_ide_dan", length = 50)
    private String danger;
    @Column(name = "risk_iperc_det_ide_risk", length = 50)
    private String risk;
    @Column(name = "risk_iperc_det_ide_cons", length = 50)
    private String consequence;
    @Column(name = "risk_iperc_det_eva_c")
    private int evaC;
    @Column(name = "risk_iperc_det_eva_p")
    private int evaP;
    @Column(name = "risk_iperc_det_eva_e")
    private int evaE;
    @Column(name = "risk_iperc_det_eva_val")
    private int evaVal;
    @Column(name = "risk_iperc_det_eva_type", length = 10)
    private String evaType;
    @Column(name = "risk_iperc_det_eva_desc", length = 200)
    private String evaDesc;
    @Column(name = "risk_iperc_det_eva_lev", length = 50)
    private String evaLev;
    @Column(name = "risk_iperc_det_eva_ing", length = 50)
    private String contIng;
    @Column(name = "risk_iperc_det_eva_adm", length = 50)
    private String contAdm;
    @Column(name = "risk_iperc_det_eva_insp", length = 50)
    private String contInsp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "risk_iperc_id")
    private RiskIperc riskIperc;

//    @ManyToMany
//    @JoinTable(name = "risk_iperc_incident",
//            joinColumns = @JoinColumn(name = "risk_iperc_det_id"),
//            inverseJoinColumns = @JoinColumn(name = "incident_id"))
//    private Set<Incident> incidents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getDanger() {
        return danger;
    }

    public void setDanger(String danger) {
        this.danger = danger;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getConsequence() {
        return consequence;
    }

    public void setConsequence(String consequence) {
        this.consequence = consequence;
    }

    public int getEvaC() {
        return evaC;
    }

    public void setEvaC(int evaC) {
        this.evaC = evaC;
    }

    public int getEvaP() {
        return evaP;
    }

    public void setEvaP(int evaP) {
        this.evaP = evaP;
    }

    public int getEvaE() {
        return evaE;
    }

    public void setEvaE(int evaE) {
        this.evaE = evaE;
    }

    public int getEvaVal() {
        return evaVal;
    }

    public void setEvaVal(int evaVal) {
        this.evaVal = evaVal;
    }

    public String getEvaType() {
        return evaType;
    }

    public void setEvaType(String evaType) {
        this.evaType = evaType;
    }

    public String getEvaDesc() {
        return evaDesc;
    }

    public void setEvaDesc(String evaDesc) {
        this.evaDesc = evaDesc;
    }

    public String getEvaLev() {
        return evaLev;
    }

    public void setEvaLev(String evaLev) {
        this.evaLev = evaLev;
    }

    public String getContIng() {
        return contIng;
    }

    public void setContIng(String contIng) {
        this.contIng = contIng;
    }

    public String getContAdm() {
        return contAdm;
    }

    public void setContAdm(String contAdm) {
        this.contAdm = contAdm;
    }

    public String getContInsp() {
        return contInsp;
    }

    public void setContInsp(String contInsp) {
        this.contInsp = contInsp;
    }

    public RiskIperc getRiskIperc() {
        return riskIperc;
    }

    public void setRiskIperc(RiskIperc riskIperc) {
        this.riskIperc = riskIperc;
    }

//    public Set<Incident> getIncidents() {
//        return incidents;
//    }
//
//    public void setIncidents(Set<Incident> incidents) {
//        this.incidents = incidents;
//    }
}
