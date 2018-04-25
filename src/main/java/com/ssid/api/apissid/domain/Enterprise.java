
package com.ssid.api.apissid.domain;
import javax.persistence.*;

/**
 * @author vanessa alcocer
 */
@Entity
@Table(name = "enterprise")
public class Enterprise {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "enterprise_id")
    private Long id;

    @Column(name = "enterprise_name", length = 50,unique = true)
    private String enterpriseName;

    @Column(name = "enterprise_description", length = 50,unique = true)
    private String enterpriseDescription;



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

}

