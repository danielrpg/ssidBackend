package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.Personal;
import com.ssid.api.apissid.services.PersonalService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author daniel fernandez
 */
@RestController
public class PersonalController {

    private PersonalService personalService;

    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    @GetMapping(path = ApiPath.PERSONAL_PATH)
    public List<Personal> getListPersonal(){
        return this.personalService.getListPersonal();
    }
}
