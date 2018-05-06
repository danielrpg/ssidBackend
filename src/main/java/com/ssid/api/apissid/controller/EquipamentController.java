package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.Equipament;
import com.ssid.api.apissid.services.EquipamentService;
import com.ssid.api.apissid.command.EquipamentCommand;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<EquipamentCommand> getListEquipament(){

        List<EquipamentCommand> equipamentCommadsList = new ArrayList<>();

        this.equipamentService.getListEquipament().forEach(equipament -> {
            equipamentCommadsList.add(new EquipamentCommand(equipament));
        });
        return equipamentCommadsList;
    }

    @RequestMapping(value = ApiPath.EQUIPAMENT_PATH, method = RequestMethod.POST)
    public @ResponseBody void saveEquipament(@RequestBody EquipamentCommand equipamentCommad){
        this.equipamentService.saveEquipament(equipamentCommad.toEquipament());
    }

    @RequestMapping(value = ApiPath.EQUIPAMENT_BY_ID, method = RequestMethod.GET)
    public @ResponseBody
    EquipamentCommand findEquipamentById(@PathVariable(value = "id") Long id){

        Optional<Equipament> equipament = equipamentService.getEquipamentById(id);
        return new EquipamentCommand(equipament.get());
    }

    @RequestMapping(value = ApiPath.EQUIPAMENT_BY_ID, method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteEquipamentById(@PathVariable(value = "id") Long id){
        this.equipamentService.deleteEquipamentById(id);
    }

    @RequestMapping(path = ApiPath.EQUIPAMENT_PATH, method = RequestMethod.PUT)
    public @ResponseBody
    EquipamentCommand updateEquipament(@RequestBody EquipamentCommand equipament, @PathVariable(value = "id") Long id){

        Equipament update =this.equipamentService.updateEquipament(equipament.toEquipament(), id);
        return new EquipamentCommand(update);
    }
}
