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

    private String reportadopor;
    private String formadeaccidente;
    private String tipodelesion;
    private String partedelcuerpolesionada;
    private String agentecausante;
    private String tipodeaccidente;

    public AccidentCommand(){
    }

    public AccidentCommand(Accident accident){
        setId(accident.getId());
        setPersonal(accident.getPersonal());
        setFecha(accident.getDateAt());
        setBajamedica(accident.getBajamedica());
        setLugaratencion(accident.getLugaratencion());
        setDescripcion(accident.getDescription());

        setReportadopor(accident.getReportBy());
        setFormadeaccidente(accident.getInjuryForm().getName());
        setTipodelesion(accident.getInjuryType());
        setPartedelcuerpolesionada(accident.getInjuryBody());
        setAgentecausante(accident.getCausingAgent());
        setTipodeaccidente(accident.getAccidentType());
    }

    public Accident toAccident(){
        Accident accident = new Accident();
        accident.setId(getId());
        accident.setPersonal(getPersonal());
        accident.setDateAt(getFecha());
        accident.setBajamedica(getBajamedica());
        accident.setLugaratencion(getLugaratencion());
        accident.setDescription(getDescripcion());

        accident.setReportBy(getReportadopor());
        // accident.setInjuryForm(getFormadeaccidente());
        accident.setInjuryType(getTipodelesion());
        accident.setInjuryBody(getPartedelcuerpolesionada());
        accident.setCausingAgent(getAgentecausante());
        accident.setAccidentType(getTipodeaccidente());
        return accident;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReportadopor() {
        return reportadopor;
    }

    public void setReportadopor(String reportadopor) {
        this.reportadopor = reportadopor;
    }

    public String getFormadeaccidente() {
        return formadeaccidente;
    }

    public void setFormadeaccidente(String formadeaccidente) {
        this.formadeaccidente = formadeaccidente;
    }

    public String getTipodelesion() {
        return tipodelesion;
    }

    public void setTipodelesion(String tipodelesion) {
        this.tipodelesion = tipodelesion;
    }

    public String getPartedelcuerpolesionada() {
        return partedelcuerpolesionada;
    }

    public void setPartedelcuerpolesionada(String partedelcuerpolesionada) {
        this.partedelcuerpolesionada = partedelcuerpolesionada;
    }

    public String getAgentecausante() {
        return agentecausante;
    }

    public void setAgentecausante(String agentecausante) {
        this.agentecausante = agentecausante;
    }

    public String getTipodeaccidente() {
        return tipodeaccidente;
    }

    public void setTipodeaccidente(String tipodeaccidente) {
        this.tipodeaccidente = tipodeaccidente;
    }
}
