package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.Equipament;
import com.ssid.api.apissid.services.EquipamentService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author daniel fernandez
 */
@RestController
public class EquipamentController {

    private EquipamentService equipamentService;

    public EquipamentController(EquipamentService equipamentService) {
        this.equipamentService = equipamentService;
    }

    @GetMapping(path = ApiPath.EQUIPAMENT_PATH)
    public List<Equipament> getListEquipament(){
        return this.equipamentService.getListEquipament();
    }

    @RequestMapping(value = ApiPath.EQUIPAMENT_PATH, method = RequestMethod.POST)
    public @ResponseBody void saveEquipament(@RequestBody Equipament equipament){
        this.equipamentService.saveEquipament(equipament);
    }
}
