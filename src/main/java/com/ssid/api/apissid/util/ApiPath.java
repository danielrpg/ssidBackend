package com.ssid.api.apissid.util;

/**
 * @author daniel fernandez
 */
public class ApiPath {

    public static final String VERSION_API = "/api/v1";

    //this path for login
    public static final String LOGIN_URL = VERSION_API + "/login";

    //This are constants for User
    public static final String USER_PATH = VERSION_API + "/users";

    //This are constants for personal
    public static final String PERSONAL_PATH = VERSION_API + "/personal";

    //This are constants for Equipament
    public static final String EQUIPAMENT_PATH = VERSION_API + "/equipament";


    //This are constants for RiskIpercDetail
    public static final String  RISK_IPERC_DETAIL_PATH = VERSION_API + "/riskipercdetail";

    //This are constants for RiskIperc
    public static final String  RISK_IPERC_PATH = VERSION_API + "/riskiperc";



    //This are constants for ActivitiesSso
    public static final String ACTIVITIES_SSO_PATH = VERSION_API + "/activitiessso";

    //This are constants for ResourceSso
    public static final String RESOURCES_SSO_PATH = VERSION_API + "/resourcessso";
}