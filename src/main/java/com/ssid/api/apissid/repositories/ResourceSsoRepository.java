package com.ssid.api.apissid.repositories;

import com.ssid.api.apissid.domain.Personal;
import com.ssid.api.apissid.domain.ResourceSso;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

public interface ResourceSsoRepository extends JpaRepository<ResourceSso, Long>{


}
