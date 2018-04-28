package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.TrainersSso;

import java.util.List;
import java.util.Optional;

public interface TrainersSsoService {
    List<TrainersSso> getTrainerssSso();
    TrainersSso saveTrainersSso(TrainersSso trainersSso);
    Optional<TrainersSso> getTrainersSsoById(Long id);
    void deleteTrainersSsoById(Long id);
    TrainersSso updateTrainersSso(TrainersSso trainersSso, Long id);
}
