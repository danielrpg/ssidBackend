package com.ssid.api.apissid.controller;


import com.ssid.api.apissid.command.AssignEquipamentCommand;
import com.ssid.api.apissid.services.AssignEquipamentService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = ApiPath.ASSIGN_PATH)
public class AssignEquipamentController {

    private AssignEquipamentService assignEquipamentService;

    public AssignEquipamentController(AssignEquipamentService assignEquipamentService) {
        this.assignEquipamentService = assignEquipamentService;
    }

    @RequestMapping(value = "/assignPersonalEquipament", method = RequestMethod.POST)
    public void assignPersonalEquipament(@RequestBody AssignEquipamentCommand assignEquipamentCommand){
        this.assignEquipamentService.assignEquipamentToPersonal(assignEquipamentCommand);
    }


}
