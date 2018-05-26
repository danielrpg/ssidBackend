package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.AccidentType;
import com.ssid.api.apissid.repositories.AccidentTypeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AccidentTypeServiceImpl extends GenericServiceImpl<AccidentType> implements AccidentTypeService{
    private AccidentTypeRepository accidentTypeRepository;

    public AccidentTypeServiceImpl(AccidentTypeRepository accidentTypeRepository) {
        this.accidentTypeRepository = accidentTypeRepository;
    }

    @Override
    protected JpaRepository<AccidentType, Long> getRepository() {
        return accidentTypeRepository;
    }
}
