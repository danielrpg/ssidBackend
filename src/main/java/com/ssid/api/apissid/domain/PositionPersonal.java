package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Jesus David Piérola Alvarado
 */

@Entity
@Table(name = "position_personal")
public class PositionPersonal implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "function_personal_id")
    private Long id;

    @OneToOne
    private Personal personal;

    @OneToOne
    private Position position;
}
