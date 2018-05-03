package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
}
