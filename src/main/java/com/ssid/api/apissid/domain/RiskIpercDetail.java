package com.ssid.api.apissid.domain;

import javax.persistence.*;

/**
 * @author Jesus David Piérola Alvarado
 */

@Entity
@Table(name = "rich_iperc_detail")
public class RiskIpercDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "risk_iperc_det_id")
    private int id;
    @Column(name = "risk_iperc_det_ide_acti", length = 50)
    private String activity;
    @Column(name = "risk_iperc_det_ide_cond", length = 50)
    private String condition;
    @Column(name = "risk_iperc_det_ide_act", length = 50)
    private String act;
    @Column(name = "risk_iperc_det_ide_dan", length = 50)
    private String danger;
    @Column(name = "risk_iperc_det_ide_risk", length = 50)
    private String risk;
    @Column(name = "risk_iperc_det_ide_cons", length = 50)
    private String consequence;
    @Column(name = "risk_iperc_det_eva_c")
    private int evaC;
    @Column(name = "risk_iperc_det_eva_p")
    private int evaP;
    @Column(name = "risk_iperc_det_eva_e")
    private int evaE;
    @Column(name = "risk_iperc_det_eva_val")
    private int evaVal;
    @Column(name = "risk_iperc_det_eva_type", length = 10)
    private String evaType;
    @Column(name = "risk_iperc_det_eva_desc", length = 200)
    private String evaDesc;
    @Column(name = "risk_iperc_det_eva_lev", length = 50)
    private String evaLev;
    @Column(name = "risk_iperc_det_eva_ing", length = 50)
    private String contIng;
    @Column(name = "risk_iperc_det_eva_adm", length = 50)
    private String contAdm;
    @Column(name = "risk_iperc_det_eva_insp", length = 50)
    private String contInsp;

    //TODO: import reference to tables.

}
