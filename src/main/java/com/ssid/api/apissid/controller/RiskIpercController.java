package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.RiskIperc;
import com.ssid.api.apissid.services.RiskIpercDetailService;
import com.ssid.api.apissid.services.RiskIpercService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.*;

/**
 * @author Marcos Bustos Jimenez
 */

@RestController
public class RiskIpercController {

    private RiskIpercService riskIpercService;

    public RiskIpercController(RiskIpercService riskIpercService){
        this.riskIpercService = riskIpercService;
    }

    @GetMapping(path = ApiPath.RISK_IPERC_PATH)
    private String getRiskIpercs(){
        return "List riskIperc";
    }

    @RequestMapping(value = ApiPath.RISK_IPERC_PATH, method = RequestMethod.POST)
    public @ResponseBody
    void saveRiskIpercController(@RequestBody RiskIperc riskIperc) {
        this.riskIpercService.(activitiesSso);
    }
}
