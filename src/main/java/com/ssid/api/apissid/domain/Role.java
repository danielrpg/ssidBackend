package com.ssid.api.apissid.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * @author daniel fernandez
 */

@Entity
@Table(name = "roles")
public class Role extends ModelBase {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name", length = 200,unique = true)
    private String roleName;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles",   fetch=FetchType.EAGER)
    private Set<UserSystem> userSystems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<UserSystem> getUserSystems() {
        return userSystems;
    }

    public void setUserSystems(Set<UserSystem> userSystems) {
        this.userSystems = userSystems;
    }
}
