package com.ssid.api.apissid.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

/**
 * @author Daniel Fernandez
 */

public class JwtUtil {


    /**
     * Método para crear el JWT y enviarlo al cliente en el header de la respuesta
     * @param res, username
     */

    public static void addAuthentication(HttpServletResponse res, String username) {

        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + ApplicationConstants.TIME_EXPIRE))
                .signWith(SignatureAlgorithm.HS512, ApplicationConstants.SSID_KEY)
                .compact();

        res.addHeader("Authorization", "Bearer " + token);
    }

    /**
     * Método para validar el token enviado por el cliente
     * @param request
     */

    public  static Authentication getAuthentication(HttpServletRequest request) {


        String token = request.getHeader("Authorization");

        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(ApplicationConstants.SSID_KEY)
                    .parseClaimsJws(token.replace("Bearer", ""))
                    .getBody()
                    .getSubject();

            return user != null ?
                    new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
                    null;
        }
        return null;
    }
}
