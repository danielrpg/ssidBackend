package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.ActivitiesSso;

import java.util.List;

public interface ActivitiesSsoService {
    List<ActivitiesSso> getActivitiesSso();
    void saveActivitiesSso(ActivitiesSso activitiesSso);
}
