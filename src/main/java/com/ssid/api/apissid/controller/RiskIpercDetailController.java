package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.RiskIpercDetailCommand;
import com.ssid.api.apissid.domain.RiskIpercDetail;
import com.ssid.api.apissid.services.RiskIpercDetailService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marcos Bustos Jimenez
 */

@RequestMapping(value = ApiPath.RISK_IPERC_DETAIL_PATH)
@RestController
public class RiskIpercDetailController {

    private RiskIpercDetailService riskIpercDetailService;

    @Autowired
    public RiskIpercDetailController(RiskIpercDetailService riskIpercDetailService){
        this.riskIpercDetailService = riskIpercDetailService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getListRiskIpercDetail() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<RiskIpercDetailCommand> riskIpercDetailList = new ArrayList<>();
        this.riskIpercDetailService.findAll().forEach(riskIpercDetail -> {
            riskIpercDetailList.add(new RiskIpercDetailCommand(riskIpercDetail));
        });
        mapResponse.put("data", riskIpercDetailList);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> findRiskIpercDetailById(@PathVariable Long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        RiskIpercDetail riskIpercDetail = this.riskIpercDetailService.findById(id);

        if (riskIpercDetail != null) {
            mapResponse.put("status", "ok");
            mapResponse.put("data", new RiskIpercDetailCommand(riskIpercDetail));
            return new ResponseEntity<>(mapResponse, HttpStatus.OK);
        } else {
            mapResponse.put("status", "not found");
            mapResponse.put("data", null);
            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> saveRiskIpercDetail(@RequestBody RiskIpercDetailCommand riskIpercDetailCommand) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "created");
        mapResponse.put("data", riskIpercDetailService.save(riskIpercDetailCommand.toRiskIpercDetail()));
        return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateRiskIpercDetail(@RequestBody RiskIpercDetailCommand riskIpercDetailCommand, @PathVariable int id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "updated");
        mapResponse.put("data", riskIpercDetailService.update(riskIpercDetailCommand.toRiskIpercDetail(), (long) id));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteRiskIpercDetail(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "deleted");
        this.riskIpercDetailService.deleteById(id);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}
