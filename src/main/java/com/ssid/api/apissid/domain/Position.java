package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Jesus David Piérola Alvarado
 */

@Entity
@Table(name = "position")
public class Position extends ModelBase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Long id;

    @Column(name = "position_name", length = 300)
    private String name;

    @Column(name = "position_description", length = 800)
    private String description;

    @Column(name = "position_level")
    private Integer level;

    @ManyToMany(mappedBy = "positions", fetch = FetchType.EAGER)
    private Set<Department> departments;

    @OneToMany(mappedBy = "position",
            cascade = {CascadeType.ALL})
    private Set<PersonalPositionContract> personalPositionContracts;

    @OneToOne(optional = true)
    private Position parentPosition;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Set<PersonalPositionContract> getPersonalPositionContracts() {
        return personalPositionContracts;
    }

    public void setPersonalPositionContracts(Set<PersonalPositionContract> personalPositionContracts) {
        this.personalPositionContracts = personalPositionContracts;
    }

    public Position getParentPosition() {
        return parentPosition;
    }

    public void setParentPosition(Position parentPosition) {
        this.parentPosition = parentPosition;
    }
}
