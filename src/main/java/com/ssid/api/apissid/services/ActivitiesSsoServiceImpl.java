package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.ActivitiesSso;
import com.ssid.api.apissid.repositories.ActivitiesSsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<ActivitiesSso> getActivitieById(Long id) {
        return activitiesSsoRepository.findById(id);
    }

    @Override
    public void deleteActivitieById(Long id) {
        Optional<ActivitiesSso> activitiesSso = activitiesSsoRepository.findById(id);
        activitiesSsoRepository.delete(activitiesSso.get());
    }

    @Override
    public ActivitiesSso updateActivitie(ActivitiesSso activitiesSso, Long id) {
        Optional<ActivitiesSso> activitieUpdate = this.activitiesSsoRepository.findById(id);
        if(!activitieUpdate.isPresent())
            return null;
        activitiesSso.setId(id);
        this.activitiesSsoRepository.save(activitiesSso);
        return activitiesSso;
    }
}
