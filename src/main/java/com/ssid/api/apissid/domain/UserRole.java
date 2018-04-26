package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

/**
 * @author Jesus David Piérola Alvarado
 */

@Entity
@Table(name = "user_role")
public class UserRole extends ModelBase implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "position_personal_id")
    private Long id;

    @OneToOne(optional = false)
    private UserSystem user;

    @OneToOne(optional = false)
    private Role role;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
