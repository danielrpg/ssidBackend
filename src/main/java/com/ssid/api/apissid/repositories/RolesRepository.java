package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Long>{
}
