package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.Area;
import com.ssid.api.apissid.domain.Personal;

import java.util.Date;

/**
 * @author Jesus David Piérola Alvarado
 */

public class PersonalCommand {
    private Long id;
    private String firstname;
    private String lastname;
    private Byte[] photo;
    private String email;
    private String address;
    private String cellphone;
    private String telephone;
    private Boolean active;
    private Date birthdate;
    private Long areaId;
    private String areaName;
    private String areaDescription;

    public PersonalCommand() {
    }

    public PersonalCommand(Personal personal) {
        setId(personal.getId());
        setFirstname(personal.getName());
        setLastname(personal.getLastName());
        //setPhoto(personal.getPhoto());
        setEmail(personal.getEmail());
        setAddress(personal.getAddress());
        setCellphone(personal.getCellphone());
        setTelephone(personal.getTelephone());
        setActive(personal.getActive());
        //setBirthdate(personal.getBirthdate());

        Area area = personal.getArea();

//        if (area != null && personal.getArea().getId() != null) {
//            setAreaId(area.getId());
//            setAreaName(area.getName());
//            setAreaDescription(area.getDescription());
//        }
    }

    public Personal toPersonal() {
        Personal personal = new Personal();

        personal.setId(getId());
        personal.setName(getFirstname());
        personal.setLastName(getLastname());
        //personal.setPhoto(getPhoto());
        personal.setEmail(getEmail());
        personal.setAddress(getAddress());
        personal.setCellphone(getCellphone());
        personal.setTelephone(getTelephone());
        personal.setActive(getActive());
       // personal.setBirthdate(getBirthdate());

        if (getAreaId() != null && getAreaId() > 0) {
            Area area = new Area();
            area.setId(getAreaId());
            area.setName(getAreaName());
            area.setDescription(getAreaDescription());
            personal.setArea(area);
        }

        return personal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(Byte[] photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaDescription() {
        return areaDescription;
    }

    public void setAreaDescription(String areaDescription) {
        this.areaDescription = areaDescription;
    }
}
