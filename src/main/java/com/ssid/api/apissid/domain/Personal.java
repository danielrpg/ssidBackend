package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Jesus David Piérola Alvarado
 */

@Entity
@Table(name = "personal")
public class Personal implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "personal_id")
    private Long id;

    @Column(name = "personal_name", length = 50)
    private String name;

    @Column(name = "personal_email", length = 50)
    private String email;

    @Column(name = "personal_direction", length = 50)
    private String address;

    @Column(name = "personal_cellphone", length = 50)
    private String cellphone;

    @Column(name = "personal_telephone", length = 50)
    private String telephone;

    @Column(name = "personal_active")
    private Boolean active;

    @Column(name = "personal_year", length = 50)
    private String year;

    @OneToOne
    private Area area;
}
