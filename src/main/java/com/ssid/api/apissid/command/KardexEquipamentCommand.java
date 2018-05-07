package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.Equipament;
import com.ssid.api.apissid.domain.KardexEquipament;

import java.util.Date;

public class KardexEquipamentCommand {
    private Long id;
    private Long idEquipament = new Long(0);
    private Date dateKardex;
    private int entryKardex;
    private int outlayKardex;
    private int balanceKardex;

    public KardexEquipamentCommand() {
    }

    public KardexEquipamentCommand(KardexEquipament kardexEquipament) {
        setId(kardexEquipament.getId());
        setIdEquipament(kardexEquipament.getEquipament().getId());
        setDateKardex(kardexEquipament.getDateKardex());
        setEntryKardex(kardexEquipament.getEntryKardex());
        setOutlayKardex(kardexEquipament.getOutlayKardex());
        setBalanceKardex(kardexEquipament.getBalanceKardex());
    }

    public KardexEquipament toKardexEquipament(Equipament equip) {
        KardexEquipament kardexEquipament = new KardexEquipament();
        kardexEquipament.setId(getId());
        kardexEquipament.setEquipament(equip);
        kardexEquipament.setDateKardex(getDateKardex());
        kardexEquipament.setEntryKardex(getEntryKardex());
        kardexEquipament.setOutlayKardex(getOutlayKardex());
        kardexEquipament.setBalanceKardex(getBalanceKardex());
        return kardexEquipament;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEquipament() {
        return idEquipament;
    }

    public void setIdEquipament(Long idEquipament) {
        this.idEquipament = idEquipament;
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
}
