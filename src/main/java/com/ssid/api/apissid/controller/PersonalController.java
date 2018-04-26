package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.Personal;
import com.ssid.api.apissid.services.PersonalService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author Jesus David Piérola Alvarado
 */
@RestController
public class PersonalController {

    private PersonalService personalService;

    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    @GetMapping(path = ApiPath.PERSONAL_PATH)
    public List<Personal> getListPersonal() {
        return this.personalService.findAll();
    }

    @GetMapping(value = ApiPath.PERSONAL_PATH + "/id/")
    public Personal findById(@PathParam("id") long id) {
        return this.personalService.findById(id);
    }

    @GetMapping(value = ApiPath.PERSONAL_PATH + "/name/")
    public List<Personal> findByName(@PathParam("name") String name) {
        return this.personalService.findByName(name);
    }

    @RequestMapping(value = ApiPath.PERSONAL_PATH, method = RequestMethod.POST)
    public @ResponseBody
    void savePersonal(@RequestBody Personal personal) {
        this.personalService.save(personal);
    }

    @RequestMapping(value = ApiPath.PERSONAL_PATH, method = RequestMethod.PUT)
    public @ResponseBody
    void updatePersonal(@RequestBody Personal personal, @PathParam("id") long id) {
        this.personalService.update(personal, id);
    }

    @RequestMapping(value = ApiPath.PERSONAL_PATH, method = RequestMethod.DELETE)
    public @ResponseBody
    void deletePersonal(@PathParam("id") long id) {
        this.personalService.deleteById(id);
    }
}
