package com.ssid.api.apissid.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "sso_detail_id")
    private Long id;

    @Column(name = "sso_detail_activities", length = 250)
    private String detailActivities;

    @Column(name = "sso_detail_goal", length = 200)
    private String detailGoal;

    @Column(name = "so_detail_number", length = 150)
    private Integer detailNumber;

    @Column(name = "sso_detail_time")
    private String detailTime;

    @Column(name = "soo_detail_type", length = 250)
    private String detailType;

    @ManyToOne
    @JoinColumn(name = "sso_id")
    private ProgramSso programSso;

    @ManyToOne
    @JoinColumn(name = "sso_trainer_id")
    private TrainersSso trainersSso;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activitiesSso", fetch = FetchType.EAGER)
    private Set<ResourceSso> resourceSsos = new HashSet<ResourceSso>();



    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "DetailPersonalSso",
            joinColumns = @JoinColumn(name = "sso_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "personal_id"))
    private Set<Personal> personals = new HashSet<Personal>();

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

    public String getDetailTime() {
        return detailTime;
    }

    public void setDetailTime(String detailTime) {
        this.detailTime = detailTime;
    }

    public String getDetailType() {
        return detailType;
    }

    public void setDetailType(String detailType) {
        this.detailType = detailType;
    }

    public void setTrainersSso(TrainersSso trainersSso) {
        this.trainersSso = trainersSso;
    }

    public Set<Personal> getPersonals() {
        return personals;
    }

    public void setPersonals(Set<Personal> personals) {
        this.personals = personals;
    }

    public TrainersSso getTrainersSso() {
        return trainersSso;
    }
}
