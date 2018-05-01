package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Ivan Misericordia Eulate
 */

@Entity
@Table(name = "sso_detail_personal")
public class DetailPersonalSso extends ModelBase implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "sso_detail_personal")
    private Long id;

    @Column(name = "sso_personal_group", length = 50)
    private String perosnalGroup;

    @Column(name = "sso_personal_status", length = 50)
    private String personalStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerosnalGroup() {
        return perosnalGroup;
    }

    public void setPerosnalGroup(String perosnalGroup) {
        this.perosnalGroup = perosnalGroup;
    }

    public String getPersonalStatus() {
        return personalStatus;
    }

    public void setPersonalStatus(String personalStatus) {
        this.personalStatus = personalStatus;
    }
}

