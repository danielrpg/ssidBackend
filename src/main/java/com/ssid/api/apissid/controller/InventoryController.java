package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.InventoryCommand;
import com.ssid.api.apissid.domain.Equipament;
import com.ssid.api.apissid.domain.Inventory;
import com.ssid.api.apissid.domain.Personal;
import com.ssid.api.apissid.repositories.EquipamentRepository;
import com.ssid.api.apissid.repositories.PersonalRepository;
import com.ssid.api.apissid.services.InventoryService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class InventoryController {

    private InventoryService inventoryService;
    private EquipamentRepository equipamentRepository;
    private PersonalRepository personalRepository;

    public InventoryController(InventoryService inventoryService, EquipamentRepository equipamentRepository,
                               PersonalRepository personalRepository) {
        this.inventoryService = inventoryService;
        this.equipamentRepository = equipamentRepository;
        this.personalRepository = personalRepository;
    }

    @GetMapping(path = ApiPath.INVENTORY_PATH)
    public List<InventoryCommand> getListInventory(){

        List<InventoryCommand> inventoryCommadsList = new ArrayList<>();

        this.inventoryService.getInventories().forEach(inventory -> {
            inventoryCommadsList.add(new InventoryCommand(inventory));
        });
        return inventoryCommadsList;
    }

    @RequestMapping(value = ApiPath.INVENTORY_PATH, method = RequestMethod.POST)
    public @ResponseBody void saveInventory(@RequestBody InventoryCommand inventoryCommand){
        Optional<Equipament> auxEquip = equipamentRepository.findById(inventoryCommand.getIdEquipament());
        Optional<Personal> auxPer = personalRepository.findById(inventoryCommand.getIdPersonal());
        this.inventoryService.saveInventory(inventoryCommand.toInventory(auxEquip.get(), auxPer.get()));
    }

    @RequestMapping(value = ApiPath.INVERTORY_BY_ID, method = RequestMethod.GET)
    public @ResponseBody
    InventoryCommand findInventoryById(@PathVariable(value = "id") Long id){

        Optional<Inventory> inventory = inventoryService.getInventoryById(id);
        return new InventoryCommand(inventory.get());
    }

    @RequestMapping(value = ApiPath.INVERTORY_BY_ID, method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteInventoryById(@PathVariable(value = "id") Long id){
        this.inventoryService.deleteInventoryById(id);
    }

    @RequestMapping(value = ApiPath.INVENTORY_PATH, method = RequestMethod.PUT)
    public @ResponseBody
    InventoryCommand updateInventory(@RequestBody InventoryCommand inventoryCommand, @PathVariable(value = "id") Long id){
        Optional<Equipament> auxEquip = equipamentRepository.findById(inventoryCommand.getIdEquipament());
        Optional<Personal> auxPer = personalRepository.findById(inventoryCommand.getIdPersonal());
        Inventory updateInventory =this.inventoryService.updateInventory(inventoryCommand.toInventory(auxEquip.get(), auxPer.get()), id);
        return new InventoryCommand(updateInventory);
    }
}
