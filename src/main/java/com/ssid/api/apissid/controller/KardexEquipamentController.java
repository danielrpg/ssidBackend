package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.KardexEquipament;
import com.ssid.api.apissid.services.KardexEquipamentService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class KardexEquipamentController {
    private KardexEquipamentService kardexEquipamentService;

    public KardexEquipamentController(KardexEquipamentService kardexEquipamentService) {
        this.kardexEquipamentService = kardexEquipamentService;
    }

    @GetMapping(path = ApiPath.KARDEX_EQUIPAMENT_PATH)
    public List<KardexEquipament> getListkardex() {

        return kardexEquipamentService.getListKardexEquipament();
    }

    @RequestMapping(value = ApiPath.KARDEX_EQUIPAMENT_PATH, method = RequestMethod.POST)
    public @ResponseBody
    void saveKardex(@RequestBody KardexEquipament kardexEquipament) {
        this.kardexEquipamentService.saveKardexEquipament(kardexEquipament);
    }

    @RequestMapping(value = ApiPath.KARDEX_BY_ID, method = RequestMethod.GET)
    public @ResponseBody
    Optional<KardexEquipament> findKardexById(@PathVariable(value = "id") Long id){
        return this.kardexEquipamentService.getKardexEquipamentById(id);
    }

    @RequestMapping(value = ApiPath.KARDEX_BY_ID, method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteKardexById(@PathVariable(value = "id") Long id){
        this.kardexEquipamentService.deleteKardexEquipamentById(id);
    }

    @RequestMapping(value = ApiPath.KARDEX_EQUIPAMENT_PATH, method = RequestMethod.PUT)
    public @ResponseBody
    KardexEquipament updateKardex(@RequestBody KardexEquipament kardexEquipament, @PathVariable(value = "id") Long id){
        return this.kardexEquipamentService.updateKardexEquipament(kardexEquipament, id);
    }
}
