package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.ActivitiesSso;

import java.util.List;
import java.util.Optional;

public interface ActivitiesSsoService {
    List<ActivitiesSso> getActivitiesSso();
    void saveActivitiesSso(ActivitiesSso activitiesSso);
    Optional<ActivitiesSso> getActivitieById(Long id);
    void deleteActivitieById(Long id);
    ActivitiesSso updateActivitie(ActivitiesSso equipament, Long id);
}
