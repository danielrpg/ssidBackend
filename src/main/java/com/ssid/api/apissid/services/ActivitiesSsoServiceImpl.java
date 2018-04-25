package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.ActivitiesSso;
import com.ssid.api.apissid.repositories.ActivitiesSsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActivitiesSsoServiceImpl implements ActivitiesSsoService {
    private ActivitiesSsoRepository activitiesSsoRepository;

    @Autowired
    public ActivitiesSsoServiceImpl(ActivitiesSsoRepository activitiesSsoRepository) {
        this.activitiesSsoRepository = activitiesSsoRepository;
    }

    @Override
    public List<ActivitiesSso> getActivitiesSso() {
        return this.activitiesSsoRepository.findAll();
    }

    @Override
    public void saveActivitiesSso(ActivitiesSso activitiesSso){
        this.activitiesSsoRepository.save(activitiesSso);
    }
}
