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

    // Datos del accidentado
    @Column
    private String personal;

    @Column
    private Date dateAt;

    // Dias tiempo perdido dias
    @Column
    private Long bajamedica;

    // Recibio primeros auxilios
    @Column
    private String lugaratencion;

    @Column
    private String description;

    // Reportado por
    @Column
    private String reportBy;

    // Forma de accidente
    @Column
    private String injuryForm;

    // tipo de lesion
    @Column
    private String injuryType;

    // Parte del cuerpo lesionada
    @Column
    private String injuryBody;

    // Agente Causante
    @Column
    private String causingAgent;

    // Tipo de Accidente
    @Column
    private String accidentType;


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

    public String getReportBy() {
        return reportBy;
    }

    public void setReportBy(String reportBy) {
        this.reportBy = reportBy;
    }

    public String getInjuryForm() {
        return injuryForm;
    }

    public void setInjuryForm(String injuryForm) {
        this.injuryForm = injuryForm;
    }

    public String getInjuryType() {
        return injuryType;
    }

    public void setInjuryType(String injuryType) {
        this.injuryType = injuryType;
    }

    public String getInjuryBody() {
        return injuryBody;
    }

    public void setInjuryBody(String injuryBody) {
        this.injuryBody = injuryBody;
    }

    public String getCausingAgent() {
        return causingAgent;
    }

    public void setCausingAgent(String causingAgent) {
        this.causingAgent = causingAgent;
    }

    public String getAccidentType() {
        return accidentType;
    }

    public void setAccidentType(String accidentType) {
        this.accidentType = accidentType;
    }
}
