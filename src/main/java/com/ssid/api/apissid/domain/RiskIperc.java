package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Marcos Bustos Jimenez
 */

@Entity
@Table(name = "rich_iperc")
public class RiskIperc implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "risk_iperc_id")
    private Long id;

    @Column(name = "risk_iperc_goal", length = 50,unique = true)
    private String goal;

    @Column(name = "risk_iperc_area", length = 50,unique = true)
    private String area;

    @Column(name = "risk_iperc_resp", length = 50,unique = true)
    private String responsable;

    @Column(name = "risk_iperc_date",unique = true)
    private Date date;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @OneToMany(mappedBy = "riskIperc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RiskIpercDetail> riskIpercDetails = new HashSet<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Enterprise getRiskIpercDetail() {
        return enterprise;
    }

    public void setRiskIpercDetail(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Set<RiskIpercDetail> getRiskIpercDetails() {
        return riskIpercDetails;
    }

    public void setRiskIpercDetails(Set<RiskIpercDetail> riskIpercDetails) {
        this.riskIpercDetails = riskIpercDetails;
    }
}
