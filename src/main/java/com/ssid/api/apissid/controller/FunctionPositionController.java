package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.FunctionPositionCommand;
import com.ssid.api.apissid.command.RequirementCommand;
import com.ssid.api.apissid.domain.FunctionPosition;
import com.ssid.api.apissid.domain.Position;
import com.ssid.api.apissid.services.FunctionPositionService;
import com.ssid.api.apissid.services.PositionService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = ApiPath.FUNCTION_PATH)
public class FunctionPositionController {

    private FunctionPositionService functionPositionService;
    private PositionService positionService;
    @Autowired
    public FunctionPositionController(FunctionPositionService functionPositionService,PositionService positionService) {
        this.functionPositionService = functionPositionService;
        this.positionService = positionService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllFunctionPositions() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");

        List<FunctionPositionCommand> requirementList = new ArrayList<>();
        this.functionPositionService.findAll().forEach(funtionss -> {
            requirementList.add(new FunctionPositionCommand(funtionss));
        });

        mapResponse.put("data", requirementList);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getFunctionById(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        Position position = this.positionService.findById(id);
        List<FunctionPositionCommand> functionsList = new ArrayList<>();
        this.functionPositionService.findByPosition(position).forEach(functions -> {
            functionsList.add(new FunctionPositionCommand(functions));
        });

        if (!functionsList.isEmpty()) {
            mapResponse.put("status", "ok");
            mapResponse.put("data", functionsList);
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
    public ResponseEntity<Map<String, Object>> createFunctions(@RequestBody FunctionPositionCommand functionPositionCommand) {
        Map<String, Object> mapResponse = new HashMap<>();
        if(StringUtils.isEmpty(functionPositionCommand.getId())) {
            mapResponse.put("status", "created");
    //           mapResponse.put("data", requirementService.createRequirement(requirementCommand));
            functionPositionService.createFunctions(functionPositionCommand);
            return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);

        }
        else
        {
            mapResponse.put("status", "updated");
            functionPositionService.updateFunction(functionPositionCommand, functionPositionCommand.getId());
            return new ResponseEntity<>(mapResponse, HttpStatus.OK);
        }

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateFunctionPosition(@RequestBody FunctionPositionCommand functionPositionCommand, @PathVariable int id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "updated");
        mapResponse.put("data", functionPositionService.updateFunction(functionPositionCommand, (long) id));
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
