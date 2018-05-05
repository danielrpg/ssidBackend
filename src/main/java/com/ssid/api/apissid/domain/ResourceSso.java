package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author daniel fernandez
 */
@Entity
@Table(name = "program_sso_resource")
public class ResourceSso extends ModelBase implements Serializable{

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "sso_resource_id")
    private Long id;

    @Column(name = "sso_resource_detail", length = 200)
    private String resourceDetail;

    @Column(name = "sso_resource_cost")
    private Double resourceCost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sso_detail_id")
    private ActivitiesSso activitiesSso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


   public ActivitiesSso getActivitiesSso() {
        return activitiesSso;
    }

    public void setActivitiesSso(ActivitiesSso activitiesSso) {
        this.activitiesSso = activitiesSso;
    }

    public String getResourceDetail() {
        return resourceDetail;
    }

    public void setResourceDetail(String resourceDetail) {
        this.resourceDetail = resourceDetail;
    }

    public Double getResourceCost() {
        return resourceCost;
    }

    public void setResourceCost(Double resourceCost) {
        this.resourceCost = resourceCost;
    }
}
