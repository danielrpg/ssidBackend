package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Jesus David Piérola Alvarado
 */

@Entity
@Table(name = "position")
public class Position implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "position_id")
    private Long id;

    @Column(name = "position_name", length = 50)
    private String name;

    @Column(name = "position_description", length = 100)
    private String email;

    @Column(name = "position_function", length = 200)
    private String function;

    @Column(name = "position_level")
    private Integer level;

    @Column(name = "position_init_date")
    private Date initDate;

    @Column(name = "position_end_date")
    private Date endDate;
}
