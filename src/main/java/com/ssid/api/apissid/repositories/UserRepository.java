package com.ssid.api.apissid.repositories;

/**
 * @author Borisytu
 */

import com.ssid.api.apissid.domain.UserSystem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserSystem, Long> {
}
