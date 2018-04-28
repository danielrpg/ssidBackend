package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.util.Date;

@Table(name = "kardex_equipaments")
@Entity
public class KardexEquipament extends ModelBase{

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "equipament_kardex_id")
    private Long Id;

    @Column(name = "date_kardex", unique = true)
    private Date dateKardex;

    @Column(name = "entry_kardex",unique = true)
    private int entryKardex;

    @Column(name = "outlay_kardex",unique = true)
    private int outlayKardex;

    @Column(name = "balance_kardex",unique = true)
    private int balanceKardex;

    @ManyToOne(fetch = FetchType.LAZY)
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