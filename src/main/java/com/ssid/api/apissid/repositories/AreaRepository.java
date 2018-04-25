package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AreaRepository extends JpaRepository<Area, Long>{
    Optional<List<Area>> findByName(String name);

    @Override
    List<Area> findAll();
}
