package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.ProgramSsoCommand;
import com.ssid.api.apissid.domain.ProgramSso;
import com.ssid.api.apissid.services.ActivitiesSsoService;
import com.ssid.api.apissid.services.ProgramSsoService;
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
@RequestMapping(value = ApiPath.PROGRAM_SSO_PATH)
public class ProgramSsoController {

    private ProgramSsoService programSsoService;
    private ActivitiesSsoService activitiesSsoService;

    @Autowired
    public ProgramSsoController(ProgramSsoService programSsoService, ActivitiesSsoService activitiesSsoService) {
        this.programSsoService = programSsoService;
        this.activitiesSsoService = activitiesSsoService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getListPrograms() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<ProgramSsoCommand> programsList = new ArrayList<>();
        this.programSsoService.getProgramsSso().forEach(programSso -> {
            programsList.add(new ProgramSsoCommand(programSso));
        });
        mapResponse.put("data", programsList);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> findProgramById(@PathVariable Long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        ProgramSso programSso = this.programSsoService.getProgramById(id);

        if (programSso != null) {
            mapResponse.put("status", "ok");
            mapResponse.put("data", new ProgramSsoCommand(programSso));
            return new ResponseEntity<>(mapResponse, HttpStatus.OK);
        } else {
            mapResponse.put("status", "not found");
            mapResponse.put("data", null);
            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> saveProgramsSso(@RequestBody ProgramSsoCommand programSsoCommand) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "created");
        mapResponse.put("data", programSsoService.saveProgramSso(programSsoCommand.toProgramSso()));
        return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateProgram(@RequestBody ProgramSsoCommand programSsoCommand, @PathVariable int id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "updated");
        mapResponse.put("data", programSsoService.updateProgram(programSsoCommand.toProgramSso(), (long) id));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteProgramById(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "deleted");
        this.programSsoService.deleteProgramById(id);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}
