package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.Equipament;
import com.ssid.api.apissid.domain.Personal;

import java.util.List;

public class AssignEquipamentCommand {

    private Personal personal;
    private List<Equipament> equipamentList;
    private Integer numberAssigned;

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public List<Equipament> getEquipamentList() {
        return equipamentList;
    }

    public void setEquipamentList(List<Equipament> equipamentList) {
        this.equipamentList = equipamentList;
    }

    public Integer getNumberAssigned() {
        return numberAssigned;
    }

    public void setNumberAssigned(Integer numberAssigned) {
        this.numberAssigned = numberAssigned;
    }
}
