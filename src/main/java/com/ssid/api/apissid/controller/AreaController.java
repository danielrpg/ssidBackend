package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.AreaCommand;
import com.ssid.api.apissid.domain.Area;
import com.ssid.api.apissid.services.AreaService;
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
@RequestMapping(value = ApiPath.AREA_PATH)
public class AreaController {

    private AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllAreas() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<AreaCommand> areaList = new ArrayList<>();
        this.areaService.findAll().forEach(area -> {
            areaList.add(new AreaCommand(area));
        });
        mapResponse.put("data", areaList);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAreaById(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        Area area = this.areaService.findById(id);

        if (area != null) {
            mapResponse.put("status", "ok");
            mapResponse.put("data", new AreaCommand(area));
            return new ResponseEntity<>(mapResponse, HttpStatus.OK);
        } else {
            mapResponse.put("status", "not found");
            mapResponse.put("data", null);
            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAreaByName(@PathVariable String name) {
        Map<String, Object> mapResponse = new HashMap<>();
        List<AreaCommand> areaList = new ArrayList<>();
        this.areaService.findByName(name).forEach(area -> {
            areaList.add(new AreaCommand(area));
        });
        mapResponse.put("status", "ok");
        mapResponse.put("data", areaList);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> createArea(@RequestBody AreaCommand areaCommand) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "created");
        mapResponse.put("data", areaService.save(areaCommand.toArea()));
        return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateArea(@RequestBody AreaCommand areaCommand, @PathVariable int id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "updated");
        mapResponse.put("data", areaService.updateArea(areaCommand.toArea(), (long) id));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteArea(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "deleted");
        this.areaService.deleteById(id);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}
