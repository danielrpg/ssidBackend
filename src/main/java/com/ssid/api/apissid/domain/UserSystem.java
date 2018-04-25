package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author daniel fernandez
 */
@Entity
@Table(name = "users")
public class UserSystem extends ModelBase implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", length = 50,unique = true)
    private String username;

    @Column(name = "user_password", length = 50)
    private String password;

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
}