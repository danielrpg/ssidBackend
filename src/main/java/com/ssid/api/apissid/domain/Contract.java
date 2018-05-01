package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "contracts")
public class Contract extends ModelBase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contract_id")
    private Long id;

    @Column(name = "contract_code", length = 50)
    private String code;

    @Column(name = "contract_city", length = 100)
    private String city;

    @Column(name = "contract_type", length = 100)
    private String type;

    @Column(name = "contract_date", length = 50)
    private Date date;

    @Column(name = "contract_salary", length = 50)
    private Double salary;

    @Column(name = "contract_description", length = 100)
    private String description;

    @OneToMany(mappedBy = "contract",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = true)
    private Set<PersonalPositionContract> personalPositionContracts;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<PersonalPositionContract> getPersonalPositionContracts() {
        return personalPositionContracts;
    }

    public void setPersonalPositionContracts(Set<PersonalPositionContract> personalPositionContracts) {
        this.personalPositionContracts = personalPositionContracts;
    }
}
