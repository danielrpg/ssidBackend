package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "position")
public class Position implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "position_id")
    private Long id;

    @Column(name= "position_name", length = 300, unique=true)
    private String name;

    @Column(name= "position_description", length = 800)
    private String description;

    @Column(name = "position_function")
    private String function;

    @Column(name= "position_level")
    private Integer level;

    @Column(name = "position_init_date")
    private Date initDate;

    @Column(name = "position_end_date")
    private Date endDate;
}
