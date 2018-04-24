package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author Borisytu
 */
@Entity

@Table(name = "equipament")
public class Equipament implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "equipament_id")
    private Long id;

    @Column(name = "equipament_name", length = 200,unique = true)
    private String equipamentName;

    @Column(name = "equipament_description", length = 200,unique = true)
    private String equipamentDescription;

    @Column(name = "equipament_status", length = 50)
    private Integer equipamenmtStatus;

    @Column(name = "equipament_type", length = 50)
    private Integer equipamenmtType;

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
}
