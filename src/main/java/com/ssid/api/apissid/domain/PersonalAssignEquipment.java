
package com.ssid.api.apissid.domain;
import javax.persistence.*;
import java.util.Date;

/**
 * @author vanessa alcocer
 */
@Entity
@Table(name = "personal_assign_equipament")
public class PersonalAssignEquipment {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "personal_assign_equipament_id")
    private Long equipamentId;

    @Column(name = "assign_equipament_date")
    private Date assignEquipamentDate;


    public Long getEquipamentId() {
        return equipamentId;
    }

    public void setEquipamentId(Long id) {
        this.equipamentId = id;
    }

    public Date getAssignEquipamentDate() {
        return assignEquipamentDate;
    }

    public void setAssignEquipamentDate(Date assignEquipamentDate) {
        this.assignEquipamentDate = assignEquipamentDate;
    }

}

