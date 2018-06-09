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
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "sp_getAllPersonal",
                procedureName = "sp_get_all_personal",
                resultClasses = Personal.class),
        @NamedStoredProcedureQuery(
                name = "sp_deletePersonal",
                procedureName = "sp_delete_personal",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personal_id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Boolean.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "sp_createPersonal",
                procedureName = "sp_create_personal",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personal_name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personal_last_name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personal_email", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personal_direction", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personal_cellphone", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personal_telephone", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personal_active", type = Boolean.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "area_id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Boolean.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "sp_editPersonal",
                procedureName = "sp_edit_personal",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personal_id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personal_name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personal_last_name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personal_email", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personal_direction", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personal_cellphone", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personal_telephone", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personal_active", type = Boolean.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "area_id", type = Long.class),
                },
                resultClasses = Personal.class
        ),
        @NamedStoredProcedureQuery(
                name = "sp_personalById",
                procedureName = "sp_personal_by_id",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personal_id", type = Long.class)
                },
                resultClasses = Personal.class
        )
})
public class Personal extends ModelBaseAudit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personal_id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "personal_name", length = 100)
    private String name;

    @Column(name = "personal_last_name", length = 100)
    private String lastName;

//    @Lob
//    @Column(name = "personal_photo")
//    private Byte[] photo;

    @Column(name = "personal_email", length = 200)
    private String email;

    @Column(name = "personal_direction", length = 200)
    private String address;

    @Column(name = "personal_cellphone", length = 100)
    private String cellphone;

    @Column(name = "personal_telephone", length = 100)
    private String telephone;

    @Column(name = "personal_active")
    private Boolean active;

    /*@Column(name = "personal_birthdate")
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/mm/dd")
    private String birthdate;*/

    @ManyToOne
    private Area area;

    //    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personal", fetch = FetchType.LAZY)
    //private Set<Accident> accidents;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personal")
    private Set<Incident> incidents;

//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportBy", fetch = FetchType.LAZY)
    //private Set<Accident> accidentsReport;

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

//    @OneToOne
//    private AssignEquipament assignEquipament;

//    public AssignEquipament getAssignEquipament() {
//        return assignEquipament;
//    }
//
//    public void setAssignEquipament(AssignEquipament assignEquipament) {
//        this.assignEquipament = assignEquipament;
//    }

//    public Set<Accident> getAccidentsReport() {
//        return accidentsReport;
//    }
//
//    public void setAccidentsReport(Set<Accident> accidentsReport) {
//        this.accidentsReport = accidentsReport;
//    }

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

    /*public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }*/

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

//    public Byte[] getPhoto() {
//        return photo;
//    }
//
//    public void setPhoto(Byte[] photo) {
//        this.photo = photo;
//    }

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

//    public Set<Accident> getAccidents() {
//        return accidents;
//    }
//
//    public void setAccidents(Set<Accident> accidents) {
//        this.accidents = accidents;
//    }

    public Set<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(Set<Incident> incidents) {
        this.incidents = incidents;
    }
}

