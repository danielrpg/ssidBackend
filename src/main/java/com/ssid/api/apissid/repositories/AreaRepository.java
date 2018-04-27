package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by Jesus David Piérola Alvarado
 */
public interface AreaRepository extends JpaRepository<Area, Long>{
    Optional<List<Area>> findByName(String name);
}
