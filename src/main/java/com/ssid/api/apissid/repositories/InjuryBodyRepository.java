package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.InjuryBody;
import com.ssid.api.apissid.domain.InjuryForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InjuryBodyRepository extends JpaRepository<InjuryBody, Long> {
}
