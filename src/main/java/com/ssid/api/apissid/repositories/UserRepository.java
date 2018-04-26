package com.ssid.api.apissid.repositories;

/**
 * @author Borisytu
 */

import com.ssid.api.apissid.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {
}
