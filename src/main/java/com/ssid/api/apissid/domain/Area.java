package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Jesus David Piérola Alvarado
 */

@Entity
@Table(name = "area")
public class Area implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "area_id")
    private Long id;

    @Column(name = "area_name", length = 50)
    private String name;

    @Column(name = "area_description", length = 100)
    private String description;
}
