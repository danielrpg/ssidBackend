package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.ActivitiesSso;

import java.util.List;

public interface ActivitiesSsoService {
    List<ActivitiesSso> getActivitiesSso();
    ActivitiesSso saveActivitiesSso(ActivitiesSso activitiesSso);
    ActivitiesSso getActivityById(Long id);
    void deleteActivityById(Long id);
    ActivitiesSso updateActivity(ActivitiesSso activitiesSso, Long id);
}
