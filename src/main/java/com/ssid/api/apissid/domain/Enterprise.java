
package com.ssid.api.apissid.domain;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author vanessa alcocer
 */
@Entity
@Table(name = "enterprise")
public class Enterprise extends ModelBase{

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "enterprise_id")
    private Long id;

    @Column(name = "enterprise_name", length = 50)
    private String enterpriseName;

    @Column(name = "enterprise_description", length = 50)
    private String enterpriseDescription;

    @OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RiskIperc> riskIpercs = new HashSet<>();

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

    public Set<RiskIperc> getRiskIpercs() {
        return riskIpercs;
    }

    public void setRiskIpercs(Set<RiskIperc> riskIpercs) {
        this.riskIpercs = riskIpercs;
    }
}

