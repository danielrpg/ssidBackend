package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.TrainersSsoCommand;
import com.ssid.api.apissid.domain.TrainersSso;
import com.ssid.api.apissid.services.TrainersSsoService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = ApiPath.TRAINER_SSO_PATH)
public class TrainersSsoController {
    private TrainersSsoService trainersSsoService;

    @Autowired
    public TrainersSsoController(TrainersSsoService trainersSsoService) {
        this.trainersSsoService = trainersSsoService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getListTrainersSso() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<TrainersSsoCommand> trainersList = new ArrayList<>();
        this.trainersSsoService.getTrainerssSso().forEach(trainersSso -> {
            trainersList.add(new TrainersSsoCommand(trainersSso));
        });
        mapResponse.put("data", trainersList);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> findTrainersSsoById(@PathVariable Long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        TrainersSso trainersSso = this.trainersSsoService.getTrainersSsoById(id);

        if (trainersSso != null) {
            mapResponse.put("status", "ok");
            mapResponse.put("data", new TrainersSsoCommand(trainersSso));
            return new ResponseEntity<>(mapResponse, HttpStatus.OK);
        } else {
            mapResponse.put("status", "not found");
            mapResponse.put("data", null);
            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> saveTrainersSso(@RequestBody TrainersSsoCommand trainersSsoCommand) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "created");
        mapResponse.put("data", trainersSsoService.saveTrainersSso(trainersSsoCommand.toTrainersSso()));
        return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateTrainersSso(@RequestBody TrainersSsoCommand trainersSsoCommand, @PathVariable int id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "updated");
        mapResponse.put("data", trainersSsoService.updateTrainersSso(trainersSsoCommand.toTrainersSso(), (long) id));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteTrainersSsoById(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "deleted");
        this.trainersSsoService.deleteTrainersSsoById(id);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}
