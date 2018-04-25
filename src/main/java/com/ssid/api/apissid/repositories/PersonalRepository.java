package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonalRepository extends JpaRepository<Personal, Long> {
    Optional<List<Personal>> findByName(String name);

    @Override
    List<Personal> findAll();
}
