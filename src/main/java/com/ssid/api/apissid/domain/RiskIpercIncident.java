package com.ssid.api.apissid.domain;

import javax.persistence.*;

/**
 * @author Marcos Bustos Jimenez
 */

@Entity
@Table(name = "rich_iperc_incident")
public class RiskIpercIncident {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "risk_iperc_incident_id")
    private Long id;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "risk_iperc_det_id")
    private RiskIpercDetail riskIpercDetail;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "incident_id")
    private Incident incident;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RiskIpercDetail getRiskIpercDetail() {
        return riskIpercDetail;
    }

    public void setRiskIpercDetail(RiskIpercDetail riskIpercDetail) {
        this.riskIpercDetail = riskIpercDetail;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }
}
