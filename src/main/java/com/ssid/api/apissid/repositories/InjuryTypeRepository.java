package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.InjuryType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InjuryTypeRepository extends JpaRepository<InjuryType, Long> {
}
