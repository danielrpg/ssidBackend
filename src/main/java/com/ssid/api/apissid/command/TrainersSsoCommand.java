package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.TrainersSso;

//import com.sun.deploy.util.ArrayUtil;
//import sun.misc.BASE64Decoder;


public class TrainersSsoCommand {
    private Long id;
    private String name;
    private String ci;
    private String speciality;
    private String skillsDescriptions;
    private String image;
    private Object[] activitiesSsos= new Object[0];

    public TrainersSsoCommand(){}

    public TrainersSsoCommand(TrainersSso trainersSso) {
        setId(trainersSso.getId());
        setName(trainersSso.getName());
        setCi(trainersSso.getCi());
        setSpeciality(trainersSso.getSpecialty());
        setSkillsDescriptions(trainersSso.getSkillsDesciprtions());
        setImage(ImageUtilsCommand.setImageBase64(trainersSso.getImage()));
    }

    public TrainersSso toTrainersSso(){
        TrainersSso trainersSso = new TrainersSso();
        trainersSso.setId(getId());
        trainersSso.setName(getName());
        trainersSso.setCi(getCi());
        trainersSso.setSpecialty(getSpeciality());
        trainersSso.setSkillsDesciprtions(getSkillsDescriptions());
        if(getImage() != null && getImage() != "")
            trainersSso.setImage(ImageUtilsCommand.decodeToImage(getImage()));

        return trainersSso;
    }

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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSkillsDescriptions() {
        return skillsDescriptions;
    }

    public void setSkillsDescriptions(String skillsDescriptions) {
        this.skillsDescriptions = skillsDescriptions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object[] getActivitiesSsos() {
        return activitiesSsos;
    }

    public void setActivitiesSsos(Object[] activitiesSsos) {
        this.activitiesSsos = activitiesSsos;
    }
}
