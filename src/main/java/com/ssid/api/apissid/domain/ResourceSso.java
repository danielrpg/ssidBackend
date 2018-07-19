package com.ssid.api.apissid.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author daniel fernandez
 */
@Entity
@Table(name = "program_sso_resource")

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "sp_get_all_program_sso_resource",
                procedureName = "sp_get_all_program_sso_resource",
                resultClasses = ResourceSso.class),
        @NamedStoredProcedureQuery(
                name = "sp_delete_program_sso_resource",
                procedureName = "sp_delete_program_sso_resource",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "sso_resource_id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Boolean.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "sp_create_program_sso_resource",
                procedureName = "sp_create_program_sso_resource",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "resource_cost", type = Float.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "resource_detail", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Boolean.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "sp_edit_program_sso_resource",
                procedureName = "sp_edit_program_sso_resource",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "sso_resource_id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "sso_resource_cost", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "sso_resource_detail", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "sso_detail_id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Boolean.class)
                },
                resultClasses = ResourceSso.class
        ),
        @NamedStoredProcedureQuery(
                name = "sp_resourceById",
                procedureName = "sp_resourceById",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "sso_resource_id", type = Long.class)
                },
                resultClasses = ResourceSso.class
        )
})
public class ResourceSso extends ModelBase implements Serializable{

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "sso_resource_id")
    private Long id;


    @Column(name = "sso_resource_cost")
    private float resourceCost;

    @Column(name = "sso_resource_detail", length = 200)
    private String resourceDetail;

    @JsonIgnore
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

    public float getResourceCost() {
        return resourceCost;
    }

    public void setResourceCost(float resourceCost) {
        this.resourceCost = resourceCost;
    }


}