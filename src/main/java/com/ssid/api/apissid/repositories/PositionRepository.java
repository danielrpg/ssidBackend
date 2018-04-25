package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository  extends JpaRepository<Position,Long> {
}
