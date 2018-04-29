package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository <Inventory, Long> {
}
