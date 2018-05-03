package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.Accident;
import java.util.Date;

/**
 * @author Franz A. Lopez Choque
 */

public class AccidentCommand {
    private Long id;
    private Date fecha;
    private String descripcion;

    public AccidentCommand(){
    }

    public AccidentCommand(Accident accident){
        setId(accident.getAccidentId());
        setFecha(accident.getDateAt());
        setDescripcion(accident.getDescription());
    }

    public Accident toAccident(){
        Accident accident = new Accident();
        accident.setAccidentId(getId());
        accident.setDateAt(getFecha());
        accident.setDescription(getDescripcion());
        return accident;
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
