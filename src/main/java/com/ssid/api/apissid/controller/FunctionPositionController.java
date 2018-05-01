package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.FunctionPositionCommand;
import com.ssid.api.apissid.domain.FunctionPosition;
import com.ssid.api.apissid.services.FunctionPositionService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = ApiPath.FUNCTION_PATH)
public class FunctionPositionController {

    private FunctionPositionService functionPositionService;

    @Autowired
    public FunctionPositionController(FunctionPositionService functionPositionService) {
        this.functionPositionService = functionPositionService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllFunctionPositions() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<FunctionPosition> functionPositions = this.functionPositionService.findAll();
        mapResponse.put("data", functionPositions);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getFunctionPositionById(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        FunctionPosition functionPosition = this.functionPositionService.findById(id);

        if (functionPosition != null) {
            mapResponse.put("status", "ok");
            mapResponse.put("data", functionPosition);
            return new ResponseEntity<>(mapResponse, HttpStatus.OK);
        } else {
            mapResponse.put("status", "not found");
            mapResponse.put("data", null);
            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getFunctionPositionByName(@PathVariable String name) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        mapResponse.put("data", this.functionPositionService.findByName(name));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> createFunctionPosition(@RequestBody FunctionPositionCommand functionPositionCommand) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "created");
        mapResponse.put("data", functionPositionService.createFunctionPosition(functionPositionCommand));
        return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateFunctionPosition(@RequestBody FunctionPositionCommand functionPositionCommand, @PathVariable int id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "updated");
        mapResponse.put("data", functionPositionService.updateFunctionPosition(functionPositionCommand, (long) id));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteFunctionPosition(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "deleted");
        this.functionPositionService.deleteById(id);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}
