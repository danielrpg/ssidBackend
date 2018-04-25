package com.ssid.api.apissid.domain;

import javax.persistence.*;

@Entity
@Table(name = "position_personal")
public class PositionPersonal {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="position_personal_id")
    private Long id;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "position_id")
    private Position position;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "personal_id")
    private Personal personal;
}
