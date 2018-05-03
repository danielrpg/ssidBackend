package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.IncidentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentTypeRepository extends JpaRepository<IncidentType, Long> {

    IncidentType findByIncidentTypeName(String name);
}
