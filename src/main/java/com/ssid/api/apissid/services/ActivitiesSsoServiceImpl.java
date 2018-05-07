package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.ActivitiesSso;
import com.ssid.api.apissid.exceptions.NotFoundException;
import com.ssid.api.apissid.repositories.ActivitiesSsoRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@Service
public class ActivitiesSsoServiceImpl implements ActivitiesSsoService{
    private ActivitiesSsoRepository activitiesSsoRepository;

    public ActivitiesSsoServiceImpl( ActivitiesSsoRepository activitiesSsoRepository) {
        this.activitiesSsoRepository = activitiesSsoRepository;
    }

    @Override
    public List<ActivitiesSso> getActivitiesSso() {return this.activitiesSsoRepository.findAll();
    }

    @Override
    public ActivitiesSso saveActivitiesSso(ActivitiesSso activitiesSso) {
        return activitiesSsoRepository.save(activitiesSso);
    }

    @Override
    public ActivitiesSso getActivityById(Long id) {
        Optional<ActivitiesSso> optional = activitiesSsoRepository.findById(id);
        if (!optional.isPresent()) {
            String typeName = (((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
            typeName = typeName.substring(typeName.lastIndexOf(".") + 1);
            throw new NotFoundException(typeName + " id:" + id + " Not Found");
        }
        return optional.get();
    }

    @Override
    public void deleteActivityById(Long id) {
        Optional<ActivitiesSso> activitiesSso = this.activitiesSsoRepository.findById(id);
        this.activitiesSsoRepository.delete(activitiesSso.get());
    }

    @Override
    public ActivitiesSso updateActivity(ActivitiesSso activitiesSso, Long id) {
        Optional<ActivitiesSso> updateActivity = this.activitiesSsoRepository.findById(id);
        if(!updateActivity.isPresent())
            return null;
        activitiesSso.setId(id);
        this.activitiesSsoRepository.save(activitiesSso);
        return activitiesSso;
    }
}
