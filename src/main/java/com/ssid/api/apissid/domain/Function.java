package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "function")
public class Function extends ModelBase implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "func_id")
    private Long id;

    @Column(name = "func_name", length = 50)
    private String name;

    @Column(name = "func_description", length = 200)
    private String description;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
