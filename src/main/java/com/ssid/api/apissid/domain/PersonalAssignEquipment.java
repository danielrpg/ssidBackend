
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
    private Long id;

    @Column(name = "assign_equipament_date")
    private Date assignEquipamentDate;


    public Long getEquipamentId() {
        return id;
    }

    public void setEquipamentId(Long id) {
        this.id = id;
    }

    public Date getAssignEquipamentDate() {
        return assignEquipamentDate;
    }

    public void setAssignEquipamentDate(Date assignEquipamentDate) {
        this.assignEquipamentDate = assignEquipamentDate;
    }

}

