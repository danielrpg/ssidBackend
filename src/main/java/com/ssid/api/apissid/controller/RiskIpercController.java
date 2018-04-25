package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marcos Bustos Jimenez
 */

@RestController
public class RiskIpercController {
    @GetMapping(path = ApiPath.RISK_IPERC_PATH)
    private String getRiskIpercs(){
        return "List riskIperc";
    }
}