package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Created by Jesus David Piérola Alvarado
 */
public interface PersonalRepository extends JpaRepository<Personal, Long> {
    //@Query("SELECT p FROM personal p WHERE p.personal_name like ?1")
    Optional<List<Personal>> findByName(String name);
}
