package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.TrainersSso;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface TrainersSsoService {
    List<TrainersSso> getTrainerssSso();
    TrainersSso saveTrainersSso(TrainersSso trainersSso);
    TrainersSso getTrainersSsoById(Long id);
    void deleteTrainersSsoById(Long id);
    TrainersSso updateTrainersSso(TrainersSso trainersSso, Long id);
    void saveImage(Long id, InputStream inputStream);
}
