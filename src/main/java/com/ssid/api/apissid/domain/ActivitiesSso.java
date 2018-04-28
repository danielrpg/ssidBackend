package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author daniel fernandez
 * @author ivan misericordia
 */
@Entity
@Table(name = "program_sso_activities")
public class ActivitiesSso extends ModelBase implements Serializable{

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "sso_detail_id")
    private Long id;

    @Column(name = "so_detail_number", length = 50)
    private Integer detailNumber;

    @Column(name = "sso_detail_activities", length = 50)
    private String detailActivities;

    @Column(name = "sso_detail_goal", length = 50)
    private String detailGoal;

    @Column(name = "sso_detail_time")
    private Date detailTime;

    @Column(name = "soo_detail_type", length = 50)
    private String detailType;

    @Column(name = "sso_detail_responsable", length = 50)
    private String detailResponsable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sso_id")
    private ProgramSso programSso;

    @OneToMany(mappedBy = "activitiesSso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ResourceSso> resourceSsos= new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sso_trainer_id")
    private TrainersSso trainersSso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public ProgramSso getProgramSso() {
        return programSso;
    }

    public void setProgramSso(ProgramSso programSso) {
        this.programSso = programSso;
    }

    public Set<ResourceSso> getResourceSsos() {
        return resourceSsos;
    }

    public void setResourceSsos(Set<ResourceSso> resourceSsos) {
        this.resourceSsos = resourceSsos;
    }


    public Integer getDetailNumber() {
        return detailNumber;
    }

    public void setDetailNumber(Integer detailNumber) {
        this.detailNumber = detailNumber;
    }

    public String getDetailActivities() {
        return detailActivities;
    }

    public void setDetailActivities(String detailActivities) {
        this.detailActivities = detailActivities;
    }

    public String getDetailGoal() {
        return detailGoal;
    }

    public void setDetailGoal(String detailGoal) {
        this.detailGoal = detailGoal;
    }

    public Date getDetailTime() {
        return detailTime;
    }

    public void setDetailTime(Date detailTime) {
        this.detailTime = detailTime;
    }

    public String getDetailType() {
        return detailType;
    }

    public void setDetailType(String detailType) {
        this.detailType = detailType;
    }

    public String getDetailResponsable() {
        return detailResponsable;
    }

    public void setTrainersSso(TrainersSso trainersSso) {
        this.trainersSso = trainersSso;
    }

    public void setDetailResponsable(String detailResponsable) {
        this.detailResponsable = detailResponsable;
    }
}
