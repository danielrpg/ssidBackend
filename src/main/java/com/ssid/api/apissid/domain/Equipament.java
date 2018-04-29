package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * @author Borisytu
 */
@Entity

@Table(name = "equipaments")
public class Equipament extends ModelBase implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "equipament_id")
    private Long id;

    @Column(name = "equipament_name", length = 200,unique = true)
    private String name;

    @Column(name = "equipament_description", length = 200,unique = true)
    private String description;

    @Column(name = "equipament_type", length = 50)
    private Integer type;

    @Lob
    @Column(name = "equipament_image")
    private Byte[] image;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @OneToMany(mappedBy = "equipament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<KardexEquipament> kardexEquipaments= new HashSet<>();

    @ManyToMany(mappedBy = "equipaments")
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Set<Personal> getPersonals() {
        return personals;
    }

    public void setPersonals(Set<Personal> personals) {
        this.personals = personals;
    }
}
