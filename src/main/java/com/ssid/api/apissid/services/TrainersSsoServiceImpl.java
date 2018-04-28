package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.TrainersSso;
import com.ssid.api.apissid.repositories.TrainersSsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainersSsoServiceImpl implements TrainersSsoService {
    private TrainersSsoRepository trainersSsoRepository;

    @Autowired
    public TrainersSsoServiceImpl(TrainersSsoRepository trainersSsoRepository) {
        this.trainersSsoRepository = trainersSsoRepository;
    }

    @Override
    public List<TrainersSso> getTrainerssSso() {
        return trainersSsoRepository.findAll();
    }

    @Override
    public TrainersSso saveTrainersSso(TrainersSso trainersSso) {
        return trainersSsoRepository.save(trainersSso);
    }

    @Override
    public Optional<TrainersSso> getTrainersSsoById(Long id) {
        return trainersSsoRepository.findById(id);
    }

    @Override
    public void deleteTrainersSsoById(Long id) {
        trainersSsoRepository.deleteById(id);
    }

    @Override
    public TrainersSso updateTrainersSso(TrainersSso trainersSso, Long id) {
        Optional<TrainersSso> trainersSsoUpdate = this.trainersSsoRepository.findById(id);
        if(!trainersSsoUpdate.isPresent())
            return null;
        trainersSso.setId(id);
        this.trainersSsoRepository.save(trainersSso);
        return trainersSso;
    }
}
