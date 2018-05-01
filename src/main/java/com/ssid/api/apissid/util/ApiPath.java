package com.ssid.api.apissid.util;

/**
 * @author daniel fernandez
 */
public class ApiPath {

    public static final String VERSION_API = "/api/v1";

    //This are constants for personal
    public static final String AREA_PATH = VERSION_API + "/area";

    //this path for login
    public static final String LOGIN_URL = VERSION_API + "/login";

    //This are constants for User
    public static final String USER_PATH = VERSION_API + "/users";
    public static final String USER_BY_USERNAME = USER_PATH + "/{username}";

    //This are constants for personal
    public static final String PERSONAL_PATH = VERSION_API + "/personal";

    //This are constants for Equipament
    public static final String EQUIPAMENT_PATH = VERSION_API + "/equipament";
    public static final String EQUIPAMENT_BY_ID = EQUIPAMENT_PATH + "/{id}";


    //This are constants for RiskIpercDetail
    public static final String  RISK_IPERC_DETAIL_PATH = VERSION_API + "/riskipercdetail";

    //This are constants for RiskIperc
    public static final String  RISK_IPERC_PATH = VERSION_API + "/riskiperc";

    //This are constants for ActivitiesSso
    public static final String ACTIVITIES_SSO_PATH = VERSION_API + "/activitiessso";
    public static final String ACTIVITIE_BY_ID = ACTIVITIES_SSO_PATH + "/id";

    //This are constants for ResourceSso
    public static final String RESOURCES_SSO_PATH = VERSION_API + "/resourcessso";
    public static final String RESOURCE_BY_ID = RESOURCES_SSO_PATH + "/id";

    //This are constants for ProgramSso
    public static final String PROGRAM_SSO_PATH = VERSION_API + "/programssso";
    public static final String PROGRAM_BY_ID = PROGRAM_SSO_PATH + "/id";

    //This are constants for TrainerSso
    public static final String TRAINER_SSO_PATH = VERSION_API + "/trainerssso";
    public static final String TRAINER_BY_ID = TRAINER_SSO_PATH + "/id";

    // This is constants for incidents
    public static final String INCIDENT_PATH = VERSION_API + "/incidents";
    public static final String INCIDENT_TYPE_PATH = VERSION_API + "/incidenttype";

    // This is constant for Enterprise
    public static final String ENTERPRISE_PATH = VERSION_API + "/enterprise";

    // This is constant for PersonalAssignEquipament
    public static final String PERSONAL_ASSIGN_EQUIPAMENT_PATH = VERSION_API + "/personalassigequipament";

    //this is constants for KardexEquipament
    public static final String KARDEX_EQUIPAMENT_PATH = VERSION_API + "/kardexequipament";
    public static final String KARDEX_BY_ID = KARDEX_EQUIPAMENT_PATH + "/id";

    //this is constants for Inventory
    public static final String INVENTORY_PATH = VERSION_API + "/inventory";
    public static final String INVERTORY_BY_ID = INVENTORY_PATH + "/id";

}
