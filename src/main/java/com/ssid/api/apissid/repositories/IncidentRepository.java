package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
}
