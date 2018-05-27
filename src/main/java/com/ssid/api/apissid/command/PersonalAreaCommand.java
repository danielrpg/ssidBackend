package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.Area;
import com.ssid.api.apissid.domain.Personal;
import com.ssid.api.apissid.services.AreaService;

import java.util.Date;

public class PersonalAreaCommand {

    private Long id;
    private String name;
    private String lastName;
    private Byte[] photo;
    private String email;
    private String address;
    private String cellphone;
    private String telephone;
    private Boolean active;
    private Date birthdate;
    private Area area;
    private AreaService areaService;


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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AreaService getAreaService() {
        return areaService;
    }

    public void setAreaService(AreaService areaService) {
        this.areaService = areaService;
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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Personal toPersonalAndArea(PersonalAreaCommand personalAreaCommand){
        Personal personal = new Personal();
        personal.setName(personalAreaCommand.getName());
        personal.setLastName(personalAreaCommand.getLastName());
        personal.setAddress(personalAreaCommand.getAddress());
        personal.setCellphone(personalAreaCommand.getCellphone());
        personal.setEmail(personalAreaCommand.getEmail());
     //   personal.setBirthdate(personalAreaCommand.getBirthdate());
        personal.setActive(true);
        return personal;
    }

    public Area toArea(PersonalAreaCommand personalAreaCommand){
        return personalAreaCommand.getArea();
    }
}
