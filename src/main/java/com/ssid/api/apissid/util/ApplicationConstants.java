package com.ssid.api.apissid.util;
/**
 * @author daniel fernandez
 */

public class ApplicationConstants {

    public static final  String SSID_KEY= "SSID-2018"; // this is key for token generation
    public static final int TIME_EXPIRE= 2147483647; // this is for 5 minutes


    // Spring Security
    public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";

    // JWT
    public static final String ISSUER_INFO = "https://www.autentia.com/";
    public static final String SUPER_SECRET_KEY = "1234";
    public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day

}
