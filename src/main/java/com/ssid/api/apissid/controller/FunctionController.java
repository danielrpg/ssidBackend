package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.FunctionCommand;
import com.ssid.api.apissid.domain.Function;
import com.ssid.api.apissid.services.FunctionService;
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
public class FunctionController {

    private FunctionService functionService;

    @Autowired
    public FunctionController(FunctionService functionService) {
        this.functionService = functionService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllFunctions() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<Function> functions = this.functionService.findAll();
        mapResponse.put("data", functions);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getFunctionById(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        Function function = this.functionService.findById(id);

        if (function != null) {
            mapResponse.put("status", "ok");
            mapResponse.put("data", function);
            return new ResponseEntity<>(mapResponse, HttpStatus.OK);
        } else {
            mapResponse.put("status", "not found");
            mapResponse.put("data", null);
            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getFunctionByName(@PathVariable String name) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        mapResponse.put("data", this.functionService.findByName(name));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> createFunction(@RequestBody FunctionCommand functionCommand) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "created");
        mapResponse.put("data", functionService.createFunction(functionCommand));
        return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateFunction(@RequestBody FunctionCommand functionCommand, @PathVariable int id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "updated");
        mapResponse.put("data", functionService.updateFunction(functionCommand, (long) id));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteFunction(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "deleted");
        this.functionService.deleteById(id);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}
