package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "rich_iperc")
public class RiskIperc implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "risk_iperc_id")
    private int id;

    @Column(name = "risk_iperc_goal", length = 50,unique = true)
    private String goal;

    @Column(name = "risk_iperc_area", length = 50,unique = true)
    private String area;

    @Column(name = "risk_iperc_resp", length = 50,unique = true)
    private String responsable;

    @Column(name = "risk_iperc_date",unique = true)
    private Date date;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    //TODO: import reference to Enterprise table.
}
