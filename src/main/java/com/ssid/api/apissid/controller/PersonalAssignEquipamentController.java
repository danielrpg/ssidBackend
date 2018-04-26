
package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.PersonalAssignEquipament;
import com.ssid.api.apissid.services.PersonalAssignEquipamentService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PersonalAssignEquipamentController {
    private PersonalAssignEquipamentService personalAssignEquipamentService;

    public PersonalAssignEquipamentController(PersonalAssignEquipamentService personalAssignEquipamentService) {
        this.personalAssignEquipamentService = personalAssignEquipamentService;
    }

    @GetMapping(path = ApiPath.PERSONAL_ASSIGN_EQUIPAMENT_PATH)
    public List<PersonalAssignEquipament> getPersonalAssignEquipments() {
        return this.personalAssignEquipamentService.getPersonalAssignEquipament();
    }

    @RequestMapping(value = ApiPath.PERSONAL_ASSIGN_EQUIPAMENT_PATH, method = RequestMethod.POST)
    public @ResponseBody
    void savepersonalAssignEquipaments(@RequestBody PersonalAssignEquipament personalAssignEquipament) {
        this.personalAssignEquipamentService.setPersonalAssignEquipament(personalAssignEquipament);
    }
}

