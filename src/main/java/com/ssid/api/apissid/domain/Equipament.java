package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * @author Borisytu
 */
@Entity
@Table(name = "equipaments")
public class Equipament extends ModelBase implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "equipament_id")
    private Long id;

    @Column(name = "equipament_name", length = 200)
    private String equipamentName;

    @Column(name = "equipament_description", length = 200)
    private String equipamentDescription;

    @Column(name = "equipament_status")
    private Integer equipamenmtStatus;

    @Column(name = "equipament_type")
    private Integer equipamenmtType;

    @ManyToMany(mappedBy = "equipaments")
    private Set<Personal> personals;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setEquipamentName(String equipamentName) {
        this.equipamentName = equipamentName;
    }

    public String getEquipamentDescription() {
        return equipamentDescription;
    }

    public void setEquipamentDescription(String equipamentDescription) {
        this.equipamentDescription = equipamentDescription;
    }

    public Integer getEquipamenmtStatus() {
        return equipamenmtStatus;
    }

    public void setEquipamenmtStatus(Integer equipamenmtStatus) {
        this.equipamenmtStatus = equipamenmtStatus;
    }

    public Integer getEquipamenmtType() {
        return equipamenmtType;
    }

    public void setEquipamenmtType(Integer equipamenmtType) {
        this.equipamenmtType = equipamenmtType;
    }

    public String getEquipamentName() {
        return equipamentName;
    }

    public Set<Personal> getPersonals() {
        return personals;
    }

    public void setPersonals(Set<Personal> personals) {
        this.personals = personals;
    }
}
