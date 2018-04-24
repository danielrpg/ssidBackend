package com.ssid.api.apissid.domain;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name", length = 200,unique = true)
    private String username;

    @Column(name = "user_active")
    private Boolean userActive;

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

    public Boolean getUserActive() {
        return userActive;
    }

    public void setUserActive(Boolean userActive) {
        this.userActive = userActive;
    }
}
