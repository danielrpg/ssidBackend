package com.ssid.api.apissid.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 *@author Franz A. Lopez Choque
 */
@Entity
@Table(name = "accidents")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Accident extends ModelBase implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accident_id")
    @JsonProperty("id")
    private Long id;

    // Datos del accidentado
    @ManyToOne
    private Personal personal;

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
    @ManyToOne
    private Personal reportBy;

    // Forma de accidente
    @ManyToOne
    private InjuryForm injuryForm;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Date getDateAt() {
        return dateAt;
    }

    public void setDateAt(Date dateAt) {
        this.dateAt = dateAt;
    }

    public Long getBajamedica() {
        return bajamedica;
    }

    public void setBajamedica(Long bajamedica) {
        this.bajamedica = bajamedica;
    }

    public String getLugaratencion() {
        return lugaratencion;
    }

    public void setLugaratencion(String lugaratencion) {
        this.lugaratencion = lugaratencion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Personal getReportBy() {
        return reportBy;
    }

    public void setReportBy(Personal reportBy) {
        this.reportBy = reportBy;
    }

    public InjuryForm getInjuryForm() {
        return injuryForm;
    }

    public void setInjuryForm(InjuryForm injuryForm) {
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