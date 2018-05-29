package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jesus David Piérola Alvarado
 */

@Entity
@Table(name = "department")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "sp_getAllDepartments",
                procedureName = "sp_get_all_departments",
                resultClasses = Department.class),
        @NamedStoredProcedureQuery(
                name = "sp_createDepartment",
                procedureName = "sp_create_department",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "department_description", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "department_name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Boolean.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "sp_deleteDepartment",
                procedureName = "sp_delete_department",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "department_id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Boolean.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "sp_editDepartment",
                procedureName = "sp_edit_department",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "department_id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "department_description", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "department_name", type = String.class),
                },
                resultClasses = Department.class
        )
})
public class Department extends ModelBase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;

    @Column(name = "department_name", length = 50)
    private String name;

    @Column(name = "department_description", length = 100)
    private String description;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "department_position",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id"))
    private Set<Position> positions = new HashSet<Position>();

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

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }
}
