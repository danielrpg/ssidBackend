package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.Accident;
import java.util.Date;

/**
 * @author Franz A. Lopez Choque
 */

public class AccidentCommand {
    private Long id;
    private String personal;
    private Date fecha;
    private Long bajamedica;
    private String lugaratencion;
    private String descripcion;

    public AccidentCommand(){
    }

    public AccidentCommand(Accident accident){
        setId(accident.getAccidentId());
        setPersonal(accident.getPersonal());
        setFecha(accident.getDateAt());
        setBajamedica(accident.getBajamedica());
        setLugaratencion(accident.getLugaratencion());
        setDescripcion(accident.getDescription());
    }

    public Accident toAccident(){
        Accident accident = new Accident();
        accident.setAccidentId(getId());
        accident.setPersonal(getPersonal());
        accident.setDateAt(getFecha());
        accident.setBajamedica(getBajamedica());
        accident.setLugaratencion(getLugaratencion());
        accident.setDescription(getDescripcion());
        return accident;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public Long getBajamedica() {
        return bajamedica;
    }

    public void setBajamedica(Long bajamedica) {
        this.bajamedica = bajamedica;
    }

    public String getLugaratencion() {
        return lugaratencion;
    }

    public void setLugaratencion(String lugaratencion) {
        this.lugaratencion = lugaratencion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
