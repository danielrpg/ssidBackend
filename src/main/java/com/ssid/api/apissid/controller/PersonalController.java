package com.ssid.api.apissid.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ssid.api.apissid.command.PersonalAreaCommand;
import com.ssid.api.apissid.command.PersonalCommand;
import com.ssid.api.apissid.domain.Personal;
import com.ssid.api.apissid.services.PersonalService;
import com.ssid.api.apissid.util.ApiPath;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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

    @RequestMapping(value = "/{id}/image", method = RequestMethod.POST)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Map<String, Object>> uploadFile(@PathVariable long id,
                               @FormDataParam("file") InputStream file,
                               @FormDataParam("file") FormDataContentDisposition fileDisposition) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "uploaded");
        personalService.saveImage(Long.valueOf(id), file);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Personal savePersonal(@RequestBody PersonalAreaCommand personal){
        return personalService.savePersonal(personal);
    }

    @RequestMapping(value = "/getPersonalById/{id}", method = RequestMethod.GET)
    public Personal getPersonalById(@PathVariable Long id) throws JsonProcessingException {
        Personal personal = this.personalService.findById(id);
        return personal;
    }

    @RequestMapping( value = "/update/{id}", method = RequestMethod.PUT)
    public Personal updatePersonal(@RequestBody PersonalAreaCommand personalAreaCommand, @PathVariable Long id) {
        return this.personalService.updatePersonalArea(personalAreaCommand, id);
    }

    @RequestMapping( value = "/listPersonal", method = RequestMethod.GET)
    public List<Personal> listPersonals(){
        return this.personalService.getListPersonals();
    }


    @RequestMapping(value = "/havePersonalByArea/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getIfHavePersonalByArea(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<Personal> list = new ArrayList<>();
        this.personalService.findAll().stream()
                .filter(res -> res.getArea() != null && res.getArea().getId() == id)
                .forEach(personal -> {
                    list.add(personal);
                });
        //si hay resultados, existe personal que tiene asignado el Area
        if(list != null && !list.isEmpty() && list.size() > 0)
        {
            mapResponse.put("data", true);
        }
        else
        {
            mapResponse.put("data", false);
        }

        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}