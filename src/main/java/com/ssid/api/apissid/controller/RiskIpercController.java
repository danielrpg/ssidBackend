package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.RiskIpercCommand;
import com.ssid.api.apissid.domain.RiskIperc;
import com.ssid.api.apissid.services.RiskIpercService;
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

@RequestMapping(value = ApiPath.RISK_IPERC_PATH)
@RestController
public class RiskIpercController {

    private RiskIpercService riskIpercService;

    @Autowired
    public RiskIpercController(RiskIpercService riskIpercService){
        this.riskIpercService = riskIpercService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getListRiskIperc() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<RiskIpercCommand> riskIpercList = new ArrayList<>();
        this.riskIpercService.findAll().forEach(riskIperc -> {
            riskIpercList.add(new RiskIpercCommand(riskIperc));
        });
        mapResponse.put("data", riskIpercList);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        RiskIperc riskIperc = this.riskIpercService.findById(id);

        if (riskIperc != null) {
            mapResponse.put("status", "ok");
            mapResponse.put("data", new RiskIpercCommand(riskIperc));
            return new ResponseEntity<>(mapResponse, HttpStatus.OK);
        } else {
            mapResponse.put("status", "not found");
            mapResponse.put("data", null);
            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> saveRiskIperc(@RequestBody RiskIpercCommand riskIpercCommand) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "created");
        mapResponse.put("data", riskIpercService.save(riskIpercCommand.toRiskIperc()));
        return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateRiskIperc(@RequestBody RiskIpercCommand riskIpercCommand, @PathVariable int id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "updated");
        mapResponse.put("data", riskIpercService.update(riskIpercCommand.toRiskIperc(), (long) id));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteRiskIperc(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "deleted");
        this.riskIpercService.deleteById(id);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}
