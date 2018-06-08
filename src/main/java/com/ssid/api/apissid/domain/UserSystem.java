package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author daniel fernandez
 */
@Entity
@Table(name = "users")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "sp_getAllUsers",
                procedureName = "sp_get_all_users",
                resultClasses = UserSystem.class),
        @NamedStoredProcedureQuery(
                name = "sp_deleteUser",
                procedureName = "sp_delete_user",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "user_id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Boolean.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "sp_createUser",
                procedureName = "sp_create_user",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "user_name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "user_password", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "user_active", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Boolean.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "sp_editUser",
                procedureName = "sp_edit_user",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "user_id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "user_name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "user_password", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "user_active", type = Integer.class)
                },
                resultClasses = UserSystem.class
        )
})
public class UserSystem extends ModelBase implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "user_name", length = 50,unique = true)
    private String username;

    @Column(name = "user_password", length = 200)
    private String password;

    @Column(name = "user_active")
    private Boolean userActive;

    @ManyToMany( fetch=FetchType.EAGER )
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getUserActive() {
        return userActive;
    }

    public void setUserActive(Boolean userActive) {
        this.userActive = userActive;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
