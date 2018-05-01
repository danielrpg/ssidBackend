package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.PersonalCommand;
import com.ssid.api.apissid.domain.Personal;
import com.ssid.api.apissid.services.PersonalService;
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
@RequestMapping(value = ApiPath.PERSONAL_PATH)
public class PersonalController {

    private PersonalService personalService;

    @Autowired
    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getListPersonal() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<PersonalCommand> personalList = new ArrayList<>();
        this.personalService.findAll().forEach(personal -> {
            personalList.add(new PersonalCommand(personal));
        });
        mapResponse.put("data", personalList);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getPersonalById(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        Personal personal = this.personalService.findById(id);

        if (personal != null) {
            mapResponse.put("status", "ok");
            mapResponse.put("data", new PersonalCommand(personal));
            return new ResponseEntity<>(mapResponse, HttpStatus.OK);
        } else {
            mapResponse.put("status", "not found");
            mapResponse.put("data", null);
            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getPersonalByName(@PathVariable String name) {
        Map<String, Object> mapResponse = new HashMap<>();
        List<PersonalCommand> personalList = new ArrayList<>();
        this.personalService.findByName(name).forEach(personal -> {
            personalList.add(new PersonalCommand(personal));
        });
        mapResponse.put("status", "ok");
        mapResponse.put("data", personalList);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> createPersonal(@RequestBody PersonalCommand personalCommand) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "created");
        mapResponse.put("data", personalService.save(personalCommand.toPersonal()));
        return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updatePersonal(@RequestBody PersonalCommand personalCommand, @PathVariable int id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "updated");
        mapResponse.put("data", personalService.updatePersonal(personalCommand.toPersonal(), (long) id));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deletePersonal(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "deleted");
        this.personalService.deleteById(id);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}