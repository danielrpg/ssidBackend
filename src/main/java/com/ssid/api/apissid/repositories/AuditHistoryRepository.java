package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.AuditHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Boris Medrano
 */

public interface AuditHistoryRepository extends JpaRepository<AuditHistory, Long> {
    //@Query("SELECT p FROM personal p WHERE p.personal_name like ?1")
   // Optional<List<AuditHistory>> findByName(String name);
}
