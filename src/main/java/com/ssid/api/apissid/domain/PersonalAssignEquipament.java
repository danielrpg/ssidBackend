
package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author vanessa alcocer
 */
@Entity
@Table(name = "personal_assign_equipament")
public class PersonalAssignEquipament extends ModelBase {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personal_assign_equipament_id")
    private Long equipamentId;

    @Column(name = "assign_equipament_date")
    private Date assignEquipamentDate;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "personal_id")
    private Personal personal;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "equipament_id")
    private Equipament equipament;


    public Long getId() {
        return equipamentId;
    }

    public void setId(Long id) {
        this.equipamentId = equipamentId;
    }

    public Date getAssignEquipamentDate() {
        return assignEquipamentDate;
    }

    public void setAssignEquipamentDate(Date assignEquipamentDate) {
        this.assignEquipamentDate = assignEquipamentDate;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Equipament getEquipament() {
        return equipament;
    }

    public void setEquipament(Equipament equipament) {
        this.equipament = equipament;
    }

}
