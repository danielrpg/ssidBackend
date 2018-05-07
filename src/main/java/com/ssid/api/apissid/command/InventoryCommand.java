package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.Equipament;
import com.ssid.api.apissid.domain.Inventory;
import com.ssid.api.apissid.domain.Personal;

import java.util.Date;

public class InventoryCommand {
    private Long id;
    private Long idPersonal = new Long(0);
    private Long idEquipament = new Long(0);
    private String dateAsignament;
    private String status;
    private boolean active;

    public InventoryCommand() {
    }

    public InventoryCommand(Inventory inventory) {
        setId(inventory.getId());
        setIdPersonal(inventory.getPersonal().getId());
        setIdEquipament(inventory.getEquipament().getId());
        setDateAsignament(inventory.getDateAsignament().toString());
        setStatus(inventory.getStatus());
        setActive(inventory.isActive());
    }

    public Inventory toInventory(Equipament equi, Personal per) {
        Inventory inventory = new Inventory();
        inventory.setId(getId());
        inventory.setEquipament(equi);
        inventory.setPersonal(per);
        inventory.setDateAsignament(new Date(getDateAsignament()));
        inventory.setStatus(getStatus());
        inventory.setActive(isActive());
        return inventory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Long getIdEquipament() {
        return idEquipament;
    }

    public void setIdEquipament(Long idEquipament) {
        this.idEquipament = idEquipament;
    }

    public String getDateAsignament() {
        return dateAsignament;
    }

    public void setDateAsignament(String dateAsignament) {
        this.dateAsignament = dateAsignament;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
