package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.Area;
import com.ssid.api.apissid.domain.Function;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface FunctionRepository extends JpaRepository<Function, Long>{
    Optional<List<Function>> findByName(String name);
}
