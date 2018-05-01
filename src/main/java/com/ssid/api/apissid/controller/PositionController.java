package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.PositionCommand;
import com.ssid.api.apissid.domain.Position;
import com.ssid.api.apissid.services.PositionService;
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
 * @author Jesus David Piérola Alvarado
 */
@RestController
@RequestMapping(value = ApiPath.POSITION_PATH)
public class PositionController {

    private PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getListPosition() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<PositionCommand> positionList = new ArrayList<>();
        this.positionService.findAll().forEach(position -> {
            positionList.add(new PositionCommand(position));
        });
        mapResponse.put("data", positionList);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getPositionById(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        Position position = this.positionService.findById(id);

        if (position != null) {
            mapResponse.put("status", "ok");
            mapResponse.put("data", new PositionCommand(position));
            return new ResponseEntity<>(mapResponse, HttpStatus.OK);
        } else {
            mapResponse.put("status", "not found");
            mapResponse.put("data", null);
            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> createPosition(@RequestBody PositionCommand positionCommand) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "created");
        mapResponse.put("data", positionService.save(positionCommand.toPosition()));
        return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updatePosition(@RequestBody PositionCommand positionCommand, @PathVariable int id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "updated");
        mapResponse.put("data", positionService.updatePosition(positionCommand.toPosition(), (long) id));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deletePosition(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "deleted");
        this.positionService.deleteById(id);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}