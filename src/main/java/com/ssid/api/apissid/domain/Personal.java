package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Jesus David Piérola Alvarado
 */

@Entity
@Table(name = "personals")
public class Personal extends ModelBase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personal_id")
    private Long id;

    @Column(name = "personal_name", length = 50)
    private String name;

    @Lob
    @Column(name = "personal_photo")
    private Byte[] photo;

    @Column(name = "personal_email", length = 50)
    private String email;

    @Column(name = "personal_direction", length = 50)
    private String address;

    @Column(name = "personal_cellphone", length = 50)
    private String cellphone;

    @Column(name = "personal_telephone", length = 50)
    private String telephone;

    @Column(name = "personal_active")
    private Boolean active;

    @Column(name = "personal_year", length = 50)
    private String year;

    @OneToOne(optional = false)
    private Area area;

    @ManyToMany
    @JoinTable(name = "personal_assign",
            joinColumns = @JoinColumn(name = "personal_id"),
            inverseJoinColumns = @JoinColumn(name = "equipament_id"))
    private Set<Equipament> equipaments;

    @ManyToMany(mappedBy = "personals")
    private Set<Position> positions;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Set<Equipament> getEquipaments() {
        return equipaments;
    }

    public void setEquipaments(Set<Equipament> equipaments) {
        this.equipaments = equipaments;
    }

    public Byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(Byte[] photo) {
        this.photo = photo;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }
}
