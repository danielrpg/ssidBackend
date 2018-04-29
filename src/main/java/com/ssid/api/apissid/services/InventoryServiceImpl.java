package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Inventory;
import com.ssid.api.apissid.repositories.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {
    private InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<Inventory> getInventories() {
        return this.inventoryRepository.findAll();
    }

    @Override
    public void saveInventory(Inventory inventory) {
        this.inventoryRepository.save(inventory);
    }

    @Override
    public Optional<Inventory> getInventoryById(Long id) {
        return this.inventoryRepository.findById(id);
    }

    @Override
    public void deleteInventoryById(Long id) {
        Optional<Inventory> inventory = this.inventoryRepository.findById(id);
        this.inventoryRepository.delete(inventory.get());
    }

    @Override
    public Inventory updateInventory(Inventory inventory, Long id) {
        Optional<Inventory> inventoryUpdate = this.inventoryRepository.findById(id);
        if(!inventoryUpdate.isPresent())
            return null;
        inventory.setId(id);
        this.inventoryRepository.save(inventory);
        return  inventory;
    }
}
