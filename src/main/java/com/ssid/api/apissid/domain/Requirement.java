package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "requirements")
public class Requirement extends ModelBase implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "requiriment_id")
    private Long id;

    @Column(name = "requiriment_name", length = 50)
    private String name;

    @Column(name = "requiriment_description", length = 200)
    private String description;

    @ManyToOne(optional = false)
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
