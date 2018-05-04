package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 *@author Franz A. Lopez Choque
 */
@Entity
public class Accident implements Serializable {

    @Id
    @Column(name = "accident_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accidentId;

    @Column
    private String personal;

    @Column
    private Date dateAt;

    @Column
    private Long bajamedica;

    @Column
    private String lugaratencion;

    @Column
    private String description;

    public String getLugaratencion() {
        return lugaratencion;
    }

    public void setLugaratencion(String lugaratencion) {
        this.lugaratencion = lugaratencion;
    }

    public Long getBajamedica() {
        return bajamedica;
    }

    public void setBajamedica(Long bajamedica) {
        this.bajamedica = bajamedica;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public Long getAccidentId(){
        return this.accidentId;
    }

    public void setAccidentId(Long accidentId){
        this.accidentId = accidentId;

    }

    public Date getDateAt() {
        return dateAt;
    }

    public void setDateAt(Date dateAt) {
        this.dateAt = dateAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
