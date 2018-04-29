package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.TrainersSso;
import com.sun.deploy.util.ArrayUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

public class TrainersSsoCommand {
    private Long id;
    private String name;
    private String ci;
    private String specialty;
    private String skillsDesciprtions;
    private String image;
    private Object[] activitiesSsos= new Object[0];

    public TrainersSsoCommand(){}

    public TrainersSsoCommand(TrainersSso trainersSso) {
        setId(trainersSso.getId());
        setName(trainersSso.getName());
        setCi(trainersSso.getCi());
        setSpecialty(trainersSso.getSpecialty());
        setSkillsDesciprtions(trainersSso.getSkillsDesciprtions());
        setImage(ImageUtilsCommand.setImageBase64(trainersSso.getImage()));
    }

    public TrainersSso toTrainersSso(){
        TrainersSso trainersSso = new TrainersSso();
        trainersSso.setId(getId());
        trainersSso.setName(getName());
        trainersSso.setCi(getCi());
        trainersSso.setSpecialty(getSpecialty());
        trainersSso.setSkillsDesciprtions(getSkillsDesciprtions());
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSkillsDesciprtions() {
        return skillsDesciprtions;
    }

    public void setSkillsDesciprtions(String skillsDesciprtions) {
        this.skillsDesciprtions = skillsDesciprtions;
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
