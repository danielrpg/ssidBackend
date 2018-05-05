package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.Equipament;
import com.ssid.api.apissid.domain.KardexEquipament;
import com.ssid.api.apissid.repositories.EquipamentRepository;
import com.ssid.api.apissid.services.KardexEquipamentService;
import com.ssid.api.apissid.command.KardexEquipamentCommand;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class KardexEquipamentController {
    private KardexEquipamentService kardexEquipamentService;
    private EquipamentRepository equipamentRepository;

    public KardexEquipamentController(KardexEquipamentService kardexEquipamentService, EquipamentRepository equipamentRepository) {
        this.kardexEquipamentService = kardexEquipamentService;
        this.equipamentRepository = equipamentRepository;
    }

    @GetMapping(path = ApiPath.KARDEX_EQUIPAMENT_PATH)
    public List<KardexEquipamentCommand> getListKardexEquipament(){

        List<KardexEquipamentCommand> kardexEquipamentCommadsList = new ArrayList<>();

        this.kardexEquipamentService.getListKardexEquipament().forEach(kardexEquipament -> {
            kardexEquipamentCommadsList.add(new KardexEquipamentCommand(kardexEquipament));
        });
        return kardexEquipamentCommadsList;
    }

    @RequestMapping(value = ApiPath.KARDEX_EQUIPAMENT_PATH, method = RequestMethod.POST)
    public @ResponseBody void saveKardexEquipament(@RequestBody KardexEquipamentCommand kardexEquipamentCommand){
        Optional<Equipament> auxEquip = equipamentRepository.findById(kardexEquipamentCommand.getIdEquipament());
        this.kardexEquipamentService.saveKardexEquipament(kardexEquipamentCommand.toKardexEquipament(auxEquip.get()));
    }

    @RequestMapping(value = ApiPath.KARDEX_BY_ID, method = RequestMethod.GET)
    public @ResponseBody
    KardexEquipamentCommand findKardexEquipamentById(@PathVariable(value = "id") Long id){

        Optional<KardexEquipament> kardexEquipament = kardexEquipamentService.getKardexEquipamentById(id);
        return new KardexEquipamentCommand(kardexEquipament.get());
    }

    @RequestMapping(value = ApiPath.KARDEX_BY_ID, method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteKardexEquipamentById(@PathVariable(value = "id") Long id){
        this.kardexEquipamentService.deleteKardexEquipamentById(id);
    }

    @RequestMapping(value = ApiPath.KARDEX_EQUIPAMENT_PATH, method = RequestMethod.PUT)
    public @ResponseBody
    KardexEquipamentCommand updateKardexEquipament(@RequestBody KardexEquipamentCommand kardexEquipamentCommand, @PathVariable(value = "id") Long id){
        Optional<Equipament> auxEquip = equipamentRepository.findById(kardexEquipamentCommand.getIdEquipament());
        KardexEquipament updateKardexEquipament =this.kardexEquipamentService.updateKardexEquipament(kardexEquipamentCommand.toKardexEquipament(auxEquip.get()), id);
        return new KardexEquipamentCommand(updateKardexEquipament);
    }
}
