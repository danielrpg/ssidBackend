package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.Inventory;
import com.ssid.api.apissid.services.InventoryService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InventoryController {
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping(path = ApiPath.INVENTORY_PATH)
    public List<Inventory> getListInventory(){
        return this.inventoryService.getInventories();
    }

    @RequestMapping(value = ApiPath.INCIDENT_PATH, method = RequestMethod.POST)
    public @ResponseBody
    void saveInventory(@RequestBody Inventory Inventory){
        this.inventoryService.saveInventory(Inventory);
    }

    @RequestMapping(value = ApiPath.INVERTORY_BY_ID, method = RequestMethod.GET)
    public @ResponseBody
    Optional<Inventory> findInventoryById(@PathVariable(value = "id") Long id){
        return this.inventoryService.getInventoryById(id);
    }

    @RequestMapping(value = ApiPath.INVERTORY_BY_ID, method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteInventoryById(@PathVariable(value = "id") Long id){
        this.inventoryService.deleteInventoryById(id);
    }

    @RequestMapping(value = ApiPath.INVENTORY_PATH, method = RequestMethod.PUT)
    public @ResponseBody Inventory updateInventory(@RequestBody Inventory inventory, @PathVariable(value = "id") Long id){
        return this.inventoryService.updateInventory(inventory, id);
    }
}
