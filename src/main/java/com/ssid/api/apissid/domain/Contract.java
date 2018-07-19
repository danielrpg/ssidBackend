package com.ssid.api.apissid.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "contracts")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "sp_getAllContracts",
                procedureName = "sp_get_all_contracts",
                resultClasses = Contract.class),
        @NamedStoredProcedureQuery(
                name = "sp_deleteContract",
                procedureName = "sp_delete_contract",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "contract_id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Boolean.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "sp_createContract",
                procedureName = "sp_create_contract",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "contract_code", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "contract_city", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "contract_type", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "contract_date", type = Date.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "contract_salary", type = Double.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "contract_description", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Boolean.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "sp_editContract",
                procedureName = "sp_edit_contract",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "contract_id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "contract_code", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "contract_city", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "contract_type", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "contract_date", type = Date.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "contract_salary", type = Double.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "contract_description", type = String.class),
                },
                resultClasses = Contract.class
        )/*,
        @NamedStoredProcedureQuery(
                name = "sp_personalById",
                procedureName = "sp_personal_by_id",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personal_id", type = Long.class)
                },
                resultClasses = Personal.class
        )*/
})
public class Contract extends ModelBase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long id;

    @Column(name = "contract_code", length = 50)
    private String code;

    @Column(name = "contract_city", length = 100)
    private String city;

    @Column(name = "contract_type", length = 100)
    private String type;

    @Column(name = "contract_date")
    private Date date;

    @Column(name = "contract_salary")
    private Double salary;

    @Column(name = "contract_description", length = 100)
    private String description;

    @JsonIgnore
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
