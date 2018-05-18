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
    private Long resourceId;


    @Column(name = "sso_resource_cost")
    private float resourceCost;

    @Column(name = "sso_resource_detail", length = 200)
    private String resourceDetail;


 @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sso_detail_id")
    private ActivitiesSso activitiesSso;

    public Long getId() {
        return resourceId;
    }

    public void setId(Long idResource) {
        this.resourceId = idResource;
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

    public float getResourceCost() {
        return resourceCost;
    }

    public void setResourceCost(float resourceCost) {
        this.resourceCost = resourceCost;
    }


}
