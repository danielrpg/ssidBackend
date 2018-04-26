package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.RiskIperc;
import com.ssid.api.apissid.services.RiskIpercDetailService;
import com.ssid.api.apissid.services.RiskIpercService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

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
    public List<RiskIperc> getListArea() {
        return this.riskIpercService.findAll();
    }

    @RequestMapping(value = ApiPath.RISK_IPERC_PATH, method = RequestMethod.POST)
    public @ResponseBody
    void saveRiskIperc(@RequestBody RiskIperc riskIperc) {
        this.riskIpercService.save(riskIperc);
    }

    @GetMapping(value = ApiPath.RISK_IPERC_PATH + "/id/")
    public RiskIperc findById(@PathParam("id") long id) {
        return this.riskIpercService.findById(id);
    }

    @RequestMapping(value = ApiPath.RISK_IPERC_PATH, method = RequestMethod.PATCH)
    public @ResponseBody
    void updateRiskIperc(@RequestBody RiskIperc riskIperc, @PathParam("id") long id ) {
        this.riskIpercService.update(riskIperc, id);
    }

    @RequestMapping(value = ApiPath.RISK_IPERC_PATH, method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteRiskIperc(@PathParam("id") long id) {
        this.riskIpercService.deleteById(id);
    }
}
