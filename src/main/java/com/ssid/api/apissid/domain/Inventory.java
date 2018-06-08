package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "inventory")
public class Inventory extends ModelBase implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long id;

    @Column(name = "date_assignament", length = 50)
    private Date dateAsignament;

    @Column(name = "status_assignament", length = 50)
    private String status;

    @Column(name = "active_assignament")
    private boolean active;

    @ManyToOne//(cascade = {CascadeType.ALL})
    @JoinColumn(name = "equipament_id")
    private Equipament equipament;

    @ManyToOne//(cascade = {CascadeType.ALL})
    @JoinColumn(name = "personal_id")
    private Personal personal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateAsignament() {
        return dateAsignament;
    }

    public void setDateAsignament(Date dateAsignament) {
        this.dateAsignament = dateAsignament;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Equipament getEquipament() {
        return equipament;
    }

    public void setEquipament(Equipament equipament) {
        this.equipament = equipament;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
}