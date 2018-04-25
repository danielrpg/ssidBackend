package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author Borisytu
 */
@Entity

@Table(name = "equipament")
public class Equipament extends ModelBase implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "equipament_id")
    private Long id;

    @Column(name = "equipament_name", length = 200,unique = true)
    private String name;

    @Column(name = "equipament_description", length = 200,unique = true)
    private String description;

    @Column(name = "equipament_status", length = 50)
    private Integer status;

    @Column(name = "equipament_type", length = 50)
    private Integer type;

    @Lob
    @Column(name = "equipament_image")
    private Byte[] image;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }
}
