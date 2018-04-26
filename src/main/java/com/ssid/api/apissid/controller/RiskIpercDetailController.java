package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.RiskIpercDetail;
import com.ssid.api.apissid.services.RiskIpercDetailService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author Marcos Bustos Jimenez
 */

@RestController
public class RiskIpercDetailController {

    private RiskIpercDetailService riskIpercDetailService;

    public RiskIpercDetailController(RiskIpercDetailService riskIpercDetailService){
        this.riskIpercDetailService = riskIpercDetailService;
    }

    @GetMapping(path = ApiPath.RISK_IPERC_DETAIL_PATH)
    public List<RiskIpercDetail> getListRiskIpercDetail() {
        return this.riskIpercDetailService.findAll();
    }

    @RequestMapping(value = ApiPath.RISK_IPERC_DETAIL_PATH, method = RequestMethod.POST)
    public @ResponseBody
    void saveRiskIpercDetail(@RequestBody RiskIpercDetail riskIpercDetail) {
        this.riskIpercDetailService.save(riskIpercDetail);
    }

    @GetMapping(value = ApiPath.RISK_IPERC_DETAIL_PATH + "/id/")
    public RiskIpercDetail findRiskIpercDetailById(@PathParam("id") long id) {
        return this.riskIpercDetailService.findById(id);
    }

    @RequestMapping(value = ApiPath.RISK_IPERC_DETAIL_PATH, method = RequestMethod.PATCH)
    public @ResponseBody
    void updateRiskIpercDetail(@RequestBody RiskIpercDetail riskIpercDetail, @PathParam("id") long id ) {
        this.riskIpercDetailService.update(riskIpercDetail, id);
    }

    @RequestMapping(value = ApiPath.RISK_IPERC_DETAIL_PATH, method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteRiskIpercDetail(@PathParam("id") long id) {
        this.riskIpercDetailService.deleteById(id);
    }
}
