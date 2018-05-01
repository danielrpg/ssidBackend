package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RequirementRepository extends JpaRepository<Requirement, Long>{
    Optional<List<Requirement>> findByName(String name);
}
