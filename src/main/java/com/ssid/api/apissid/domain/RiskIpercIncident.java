package com.ssid.api.apissid.domain;

import javax.persistence.*;

/**
 * @author Jesus David Piérola Alvarado
 */

@Entity
@Table(name = "rich_iperc_incident")
public class RiskIpercIncident {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "risk_iperc_incident_id")
    private int id;

    //TODO: import reference to tables.

}
