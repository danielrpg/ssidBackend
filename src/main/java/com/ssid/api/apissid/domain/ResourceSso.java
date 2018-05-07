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
    private Long idResource;

    @Column(name = "sso_resource_detail", length = 200)
    private String detailResource;

    @Column(name = "sso_resource_cost")
    private Double costResource;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sso_detail_id")
    private ActivitiesSso activitiesSso;

    public Long getId() {
        return idResource;
    }

    public void setId(Long idResource) {
        this.idResource = idResource;
    }


   public ActivitiesSso getActivitiesSso() {
        return activitiesSso;
    }

    public void setActivitiesSso(ActivitiesSso activitiesSso) {
        this.activitiesSso = activitiesSso;
    }

    public String getResourceDetail() {
        return detailResource;
    }

    public void setResourceDetail(String detailResource) {
        this.detailResource = detailResource;
    }

    public Double getResourceCost() {
        return costResource;
    }

    public void setResourceCost(Double costResource) {
        this.costResource = costResource;
    }
}
