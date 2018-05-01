package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.EnterpriseCommand;
import com.ssid.api.apissid.domain.Enterprise;
import com.ssid.api.apissid.services.EnterpriseService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = ApiPath.ENTERPRISE_PATH)
public class EnterpriseController {
    private EnterpriseService enterpriseService;

    @Autowired
    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getListEnterprises() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<EnterpriseCommand> enterprisesList = new ArrayList<>();
        this.enterpriseService.findAll().forEach(enterprises -> {
            enterprisesList.add(new EnterpriseCommand(enterprises));
        });
        mapResponse.put("data", enterprisesList);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> findEnterpriseById(@PathVariable Long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        Enterprise enterprise = this.enterpriseService.findById(id);

        if (enterprise != null) {
            mapResponse.put("status", "ok");
            mapResponse.put("data", new EnterpriseCommand(enterprise));
            return new ResponseEntity<>(mapResponse, HttpStatus.OK);
        } else {
            mapResponse.put("status", "not found");
            mapResponse.put("data", null);
            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> saveEnterprises(@RequestBody EnterpriseCommand enterpriseCommand) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "created");
        mapResponse.put("data", enterpriseService.save(enterpriseCommand.toEnterprise()));
        return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateEnterprises(@RequestBody EnterpriseCommand enterpriseCommand, @PathVariable int id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "updated");
        mapResponse.put("data", enterpriseService.update(enterpriseCommand.toEnterprise(), (long) id));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteEnterprises(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "deleted");
        this.enterpriseService.deleteById(id);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}
