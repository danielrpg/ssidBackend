package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.PositionPersonal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDetailRepository extends JpaRepository<PositionPersonal, Long> {
}
