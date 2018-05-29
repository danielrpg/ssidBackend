package com.ssid.api.apissid.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "assign_equipament")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class AssignEquipament extends ModelBase implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assign_id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "assign_number")
    private Integer numberAssigned;

    @Column(name = "assign_date")
    private Date dateAsssigned;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Personal personal;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private Equipament equipament;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberAssigned() {
        return numberAssigned;
    }

    public void setNumberAssigned(Integer numberAssigned) {
        this.numberAssigned = numberAssigned;
    }

    public Date getDateAsssigned() {
        return dateAsssigned;
    }

    public void setDateAsssigned(Date dateAsssigned) {
        this.dateAsssigned = dateAsssigned;
    }

//    public Personal getPersonal() {
//        return personal;
//    }
//
//    public void setPersonal(Personal personal) {
//        this.personal = personal;
//    }
//
//    public Equipament getEquipament() {
//        return equipament;
//    }
//
//    public void setEquipament(Equipament equipament) {
//        this.equipament = equipament;
//    }
}
