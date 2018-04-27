package com.ssid.api.apissid.dto;

public class RequestPersonalDTO {
    private String name;
    private byte[] photo;
    private String email;
    private String address;
    private String cellphone;
    private String telephone;
    private String year;
    private boolean active;
    private String areaName;
    private String areaDescription;

    public RequestPersonalDTO() {
    }

    public RequestPersonalDTO(String name, byte[] photo, String email, String address, String cellphone,
                              String telephone, String year, boolean active, String areaName, String areaDescription) {
        this.name = name;
        this.photo = photo;
        this.email = email;
        this.address = address;
        this.cellphone = cellphone;
        this.telephone = telephone;
        this.year = year;
        this.active = active;
        this.areaName = areaName;
        this.areaDescription = areaDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
