package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 *@author Franz A. Lopez Choque
 */
@Entity
public class Accident implements Serializable {

    @Id
    @Column(name = "accident_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accidentId;

    @Column
    private Date dateAt;

    @Column
    private String description;

    public Long getAccidentId(){
        return this.accidentId;
    }

    public void setAccidentId(Long accidentId){
        this.accidentId = accidentId;

    }

    public Date getDateAt() {
        return dateAt;
    }

    public void setDateAt(Date dateAt) {
        this.dateAt = dateAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
