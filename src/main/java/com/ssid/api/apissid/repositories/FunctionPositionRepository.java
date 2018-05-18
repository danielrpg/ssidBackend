package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.FunctionPosition;
import com.ssid.api.apissid.domain.Position;
import com.ssid.api.apissid.domain.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FunctionPositionRepository extends JpaRepository<FunctionPosition, Long>{
    Optional<List<FunctionPosition>> findByName(String name);
    List<FunctionPosition> findByPosition(Position position);
}
