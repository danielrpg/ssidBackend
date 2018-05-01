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
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "sso_resource_id")
    private Long id;

    @Column(name = "sso_resource_detail", length = 200)
    private String resourceDetail;

    @Column(name = "sso_resource_created_on", length = 200)
    private Date resourceCreatedOn;

    @Column(name = "sso_resource_updated_on", length = 200)
    private Date resourceUpdatedOn;

    @Column(name = "sso_resource_version", length = 200)
    private long resourceVersion;

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

    public Date getResourceCreatedOn() { return resourceCreatedOn; }

    public void setResourceCreatedOn(Date resourceCreatedOn) {
        this.resourceCreatedOn = resourceCreatedOn;
    }

    public Date getResourceUpdatedOn() { return resourceUpdatedOn; }

    public void setResourceUpdatedOn(Date resourceUpdatedOn) {
        this.resourceUpdatedOn = resourceUpdatedOn;
    }

    public long getVersion() { return resourceVersion; }

    public void setVersion(long resourceVersion) {
        this.resourceVersion = resourceVersion;
    }



   /* public ActivitiesSso getActivitiesSso() {
        return activitiesSso;
    }*/

    /*public void setActivitiesSso(ActivitiesSso activitiesSso) {
        this.activitiesSso = activitiesSso;
    }*/

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
