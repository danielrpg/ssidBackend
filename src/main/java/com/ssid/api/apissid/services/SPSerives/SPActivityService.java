package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.ActivitiesSso;

import java.util.List;

public interface SPActivityService {

    List<ActivitiesSso> getAllActivities();

    Boolean deleteActivity(Long idActivity);

    Boolean createActivity(ActivitiesSso activitiesSso);

    ActivitiesSso updateActivity(Long idActivity, ActivitiesSso activitiesSso);

    ActivitiesSso getActivityById(Long idActivity);
}
