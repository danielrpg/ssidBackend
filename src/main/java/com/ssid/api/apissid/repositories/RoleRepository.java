package com.ssid.api.apissid.repositories;
/**
 * @author Borisytu
 */
import com.ssid.api.apissid.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}