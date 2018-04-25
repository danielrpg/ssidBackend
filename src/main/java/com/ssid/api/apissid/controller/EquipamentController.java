package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.Equipament;
import com.ssid.api.apissid.services.EquipamentService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = ApiPath.EQUIPAMENT_BY_ID, method = RequestMethod.GET)
    public @ResponseBody
    Optional<Equipament> findEquipamentById(@PathVariable(value = "id") Long id){
        return this.equipamentService.getEquipamentById(id);
    }

    @RequestMapping(value = ApiPath.EQUIPAMENT_BY_ID, method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteEquipamentById(@PathVariable(value = "id") Long id){
        this.equipamentService.deleteEquipamentById(id);
    }

    @RequestMapping(value = ApiPath.EQUIPAMENT_PATH, method = RequestMethod.PUT)
    public @ResponseBody Equipament updateEquipament(@RequestBody Equipament equipament, @PathVariable(value = "id") Long id){
        return this.equipamentService.updateEquipament(equipament, id);
    }
}
