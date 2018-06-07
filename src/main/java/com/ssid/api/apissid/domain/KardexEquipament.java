package com.ssid.api.apissid.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "kardex_equipaments")
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class KardexEquipament extends ModelBase implements Serializable{

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "equipament_kardex_id")
    private Long Id;

    @Column(name = "date_kardex")
    private Date dateKardex;

    @Column(name = "entry_kardex")
    private int entryKardex;

    @Column(name = "outlay_kardex")
    private int outlayKardex;

    @Column(name = "balance_kardex")
    private int balanceKardex;

    @ManyToOne
    @JoinColumn(name = "equipament_id")
    private Equipament equipament;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getDateKardex() {
        return dateKardex;
    }

    public void setDateKardex(Date dateKardex) {
        this.dateKardex = dateKardex;
    }

    public int getEntryKardex() {
        return entryKardex;
    }

    public void setEntryKardex(int entryKardex) {
        this.entryKardex = entryKardex;
    }

    public int getOutlayKardex() {
        return outlayKardex;
    }

    public void setOutlayKardex(int outlayKardex) {
        this.outlayKardex = outlayKardex;
    }

    public int getBalanceKardex() {
        return balanceKardex;
    }

    public void setBalanceKardex(int balanceKardex) {
        this.balanceKardex = balanceKardex;
    }

    public Equipament getEquipament() {
        return equipament;
    }

    public void setEquipament(Equipament equipament) {
        this.equipament = equipament;
    }
}
