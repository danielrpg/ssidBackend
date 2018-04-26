package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author Jesus David Piérola Alvarado
 */

@Entity
@Table(name = "positions")
public class Position extends ModelBase implements Serializable {
    private static final long serialVersionUID = 1L;

  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "position_id")
    private Long id;

    @Column(name = "position_name", length = 300, unique = true)
    private String name;

    @Column(name = "position_description", length = 800)
    private String description;

    @Column(name = "position_function")
    private String function;

    @Column(name = "position_level")
    private Integer level;

    @Column(name = "position_init_date")
    private Date initDate;

    @Column(name = "position_end_date")
    private Date endDate;

    @ManyToMany
    @JoinTable(name = "personal_position",
            joinColumns = @JoinColumn(name = "position_id"),
            inverseJoinColumns = @JoinColumn(name = "personal_id"))
    private Set<Personal> personals;

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

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Personal> getPersonals() {
        return personals;
    }

    public void setPersonals(Set<Personal> personals) {
        this.personals = personals;
    }
}
