package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.AccidentCommand;
import com.ssid.api.apissid.domain.Accident;
import com.ssid.api.apissid.services.AccidentService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = ApiPath.ACCIDENT_PATH)
public class AccidentController {
    private AccidentService accidentService;

    @Autowired
    public AccidentController(AccidentService accidentService){
        this.accidentService = accidentService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllAccidents() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<AccidentCommand> accidents = new ArrayList<>();
        this.accidentService.getAllAccidents().forEach(accident -> {
            accidents.add(new AccidentCommand(accident));
        });
        mapResponse.put("data", accidents);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}
