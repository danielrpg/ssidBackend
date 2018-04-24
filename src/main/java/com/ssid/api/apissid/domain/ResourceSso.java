package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author daniel fernandez
 */
@Entity
@Table(name = "program_sso_resource")
public class ResourceSso implements Serializable{

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "sso_resource_id")
    private Long id;

    @Column(name = "sso_resource_detail", length = 50)
    private Integer resourceDetail;

    @Column(name = "sso_resource_cost")
    private Double resourceCost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getResourceDetail() {
        return resourceDetail;
    }

    public void setResourceDetail(Integer resourceDetail) {
        this.resourceDetail = resourceDetail;
    }

    public Double getResourceCost() {
        return resourceCost;
    }

    public void setResourceCost(Double resourceCost) {
        this.resourceCost = resourceCost;
    }
}
