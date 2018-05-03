package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.Enterprise;

public class EnterpriseCommand {
    private Long id;
    private String enterpriseName;
    private String enterpriseDescription;
    private Object[] riskIpercs = new Object[0];

    public EnterpriseCommand(){}

    public EnterpriseCommand(Enterprise enterprise){
         setId(enterprise.getId());
         setEnterpriseName(enterprise.getEnterpriseName());
         setEnterpriseDescription(enterprise.getEnterpriseDescription());

         riskIpercs = new Object[enterprise.getRiskIpercs().size()];
    }

    public Enterprise toEnterprise(){
        Enterprise enterprise = new Enterprise();
        enterprise.setId(getId());
        enterprise.setEnterpriseName(getEnterpriseName());
        enterprise.setEnterpriseDescription(getEnterpriseDescription());

        return enterprise;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseDescription() {
        return enterpriseDescription;
    }

    public void setEnterpriseDescription(String enterpriseDescription) {
        this.enterpriseDescription = enterpriseDescription;
    }

    public Object[] getRiskIpercs() {
        return riskIpercs;
    }

    public void setRiskIpercs(Object[] riskIpercs) {
        this.riskIpercs = riskIpercs;
    }
}
