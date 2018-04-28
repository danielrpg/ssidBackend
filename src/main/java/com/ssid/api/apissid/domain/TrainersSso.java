package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "program_sso_trainer")
public class TrainersSso {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "sso_trainer_id")
    private Long id;

    @Column(name = "sso_trainer_name", length = 100)
    private String name;

    @Column(name = "sso_trainer_ci", length = 10)
    private String ci;

    @Column(name = "sso_trainer_specialty")
    private String specialty;

    @Column(name = "sso_trainer_skills")
    private String SkillsDesciprtions;

    @OneToMany(mappedBy = "trainersSso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ActivitiesSso> activitiesSsos= new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSkillsDesciprtions() {
        return SkillsDesciprtions;
    }

    public void setSkillsDesciprtions(String skillsDesciprtions) {
        SkillsDesciprtions = skillsDesciprtions;
    }

    public Set<ActivitiesSso> getActivitiesSsos() {
        return activitiesSsos;
    }

    public void setActivitiesSsos(Set<ActivitiesSso> activitiesSsos) {
        this.activitiesSsos = activitiesSsos;
    }
}
