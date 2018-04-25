package com.ssid.api.apissid.domain;

import javax.persistence.*;

@Entity
@Table(name = "position_personal")
public class PositionPersonal {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="position_personal_id")
    private Long id;

    @OneToOne
    private Position position;

    @OneToOne
    private Personal personal;
}
