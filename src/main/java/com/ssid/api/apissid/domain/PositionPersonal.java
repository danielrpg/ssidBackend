package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Jesus David Piérola Alvarado
 */

@Entity
@Table(name = "position_personal")
public class PositionPersonal extends ModelBase implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "position_personal_id")
    private Long id;

    @OneToOne(optional = false)
    private Personal personal;

    @OneToOne(optional = false)
    private Position position;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
