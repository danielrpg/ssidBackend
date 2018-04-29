package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryService {
    List<Inventory> getInventories();
    void saveInventory(Inventory inventory);
    Optional<Inventory> getInventoryById(Long id);
    void deleteInventoryById(Long id);
    Inventory updateInventory(Inventory inventory, Long id);
}
