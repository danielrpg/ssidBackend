package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.ProgramSso;
import com.ssid.api.apissid.domain.TrainersSso;
import com.ssid.api.apissid.exceptions.NotFoundException;
import com.ssid.api.apissid.repositories.ActivitiesSsoRepository;
import com.ssid.api.apissid.repositories.TrainersSsoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@Service
public class TrainersSsoServiceImpl implements TrainersSsoService {
    private static Logger logger = LoggerFactory.getLogger(TrainersSsoServiceImpl.class);
    private TrainersSsoRepository trainersSsoRepository;
    private ActivitiesSsoRepository activitiesSsoRepository;

    @Autowired
    public TrainersSsoServiceImpl(TrainersSsoRepository trainersSsoRepository,
                                  ActivitiesSsoRepository activitiesSsoRepository) {
        this.trainersSsoRepository = trainersSsoRepository;
        this.activitiesSsoRepository = activitiesSsoRepository;
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
    public TrainersSso getTrainersSsoById(Long id) {
        Optional<TrainersSso> optional = trainersSsoRepository.findById(id);
        if (!optional.isPresent()) {
            String typeName = (((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
            typeName = typeName.substring(typeName.lastIndexOf(".") + 1);
            throw new NotFoundException(typeName + " id:" + id + " Not Found");
        }
        return optional.get();
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

    @Override
    public void saveImage(Long id, InputStream file) {
        Optional<TrainersSso> trainersSsoPersisted = this.trainersSsoRepository.findById(id);

        if(trainersSsoPersisted.isPresent()) {
            try {
                Byte[] bytes = ImageUtils.inputStreamToByteArray(file);
                trainersSsoPersisted.get().setImage(bytes);
                trainersSsoRepository.save(trainersSsoPersisted.get());
            } catch (IOException e) {
                logger.error("Error reading file", e);
                e.printStackTrace();
            }
        }
    }
}
