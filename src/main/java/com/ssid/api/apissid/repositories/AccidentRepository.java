package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
}
