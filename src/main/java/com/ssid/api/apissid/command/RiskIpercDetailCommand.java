package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.RiskIpercDetail;

public class RiskIpercDetailCommand {
    private Long id;
    private String activity;
    private String condition;
    private String act;
    private String danger;
    private String risk;
    private String consequence;
    private int evaC;
    private int evaP;
    private int evaE;
    private int evaVal;
    private String evaType;
    private String evaDesc;
    private String evaLev;
    private String contIng;
    private String contAdm;
    private String contInsp;
    private RiskIpercCommand riskIperc;
    private Object[] incidents;

    public RiskIpercDetailCommand(){}

    public RiskIpercDetailCommand(RiskIpercDetail riskIpercDetail){
        setId(riskIpercDetail.getId());
        setActivity(riskIpercDetail.getActivity());
        setCondition(riskIpercDetail.getCondition());
        setAct(riskIpercDetail.getAct());
        setDanger(riskIpercDetail.getDanger());
        setRisk(riskIpercDetail.getRisk());
        setConsequence(riskIpercDetail.getConsequence());
        setEvaC(riskIpercDetail.getEvaC());
        setEvaP(riskIpercDetail.getEvaP());
        setEvaE(riskIpercDetail.getEvaE());
        setEvaVal(riskIpercDetail.getEvaVal());
        setEvaType(riskIpercDetail.getEvaType());
        setEvaDesc(riskIpercDetail.getEvaDesc());
        setEvaLev(riskIpercDetail.getEvaLev());
        setContIng(riskIpercDetail.getContIng());
        setContAdm(riskIpercDetail.getContAdm());
        setContInsp(riskIpercDetail.getContInsp());
    }

    public RiskIpercDetail toRiskIpercDetail(){
        RiskIpercDetail riskIpercDetail = new RiskIpercDetail();

        riskIpercDetail.setId(getId());
        riskIpercDetail.setActivity(getActivity());
        riskIpercDetail.setCondition(getCondition());
        riskIpercDetail.setAct(getAct());
        riskIpercDetail.setDanger(getDanger());
        riskIpercDetail.setRisk(getRisk());
        riskIpercDetail.setConsequence(getConsequence());
        riskIpercDetail.setEvaC(getEvaC());
        riskIpercDetail.setEvaP(getEvaP());
        riskIpercDetail.setEvaE(getEvaE());
        riskIpercDetail.setEvaVal(getEvaVal());
        riskIpercDetail.setEvaType(getEvaType());
        riskIpercDetail.setEvaDesc(getEvaDesc());
        riskIpercDetail.setEvaLev(getEvaLev());
        riskIpercDetail.setContIng(getContIng());
        riskIpercDetail.setContAdm(getContAdm());
        riskIpercDetail.setContInsp(getContInsp());

        return riskIpercDetail;
    }

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

    public RiskIpercCommand getRiskIperc() {
        return riskIperc;
    }

    public void setRiskIperc(RiskIpercCommand riskIperc) {
        this.riskIperc = riskIperc;
    }

    public Object[] getIncidents() {
        return incidents;
    }

    public void setIncidents(Object[] incidents) {
        this.incidents = incidents;
    }
}
