package com.ssid.api.apissid.domain;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jesus David Piérola Alvarado
 */

@Entity
@Table(name = "personals")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Personal extends ModelBase implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personal_id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "personal_name", length = 50)
    private String name;

    @Column(name = "personal_last_name", length = 50)
    private String lastName;

    @Lob
    @Column(name = "personal_photo")
    private Byte[] photo;

    @Column(name = "personal_email", length = 50)
    private String email;

    @Column(name = "personal_direction", length = 50)
    private String address;

    @Column(name = "personal_cellphone", length = 50)
    private String cellphone;

    @Column(name = "personal_telephone", length = 50)
    private String telephone;

    @Column(name = "personal_active")
    private Boolean active;

    @Column(name = "personal_birthdate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date birthdate;

    @ManyToOne
    private Area area;

    @JsonIgnore
    @OneToMany(mappedBy = "personal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Inventory> inventories = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "personal",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = true)
    private Set<PersonalPositionContract> personalPositionContracts;

    @ManyToMany(mappedBy = "personals", fetch = FetchType.EAGER)
    private Set<ActivitiesSso> activitiesSsos;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(Byte[] photo) {
        this.photo = photo;
    }

    public Set<PersonalPositionContract> getPersonalPositionContracts() {
        return personalPositionContracts;
    }

    public void setPersonalPositionContracts(Set<PersonalPositionContract> personalPositionContracts) {
        this.personalPositionContracts = personalPositionContracts;
    }

    public Set<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(Set<Inventory> inventories) {
        this.inventories = inventories;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<ActivitiesSso> getActivitiesSsos() {
        return activitiesSsos;
    }

    public void setActivitiesSsos(Set<ActivitiesSso> activitiesSsos) {
        this.activitiesSsos = activitiesSsos;
    }
}