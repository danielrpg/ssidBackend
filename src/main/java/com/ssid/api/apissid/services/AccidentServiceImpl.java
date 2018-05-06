package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Accident;
import com.ssid.api.apissid.repositories.AccidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentServiceImpl extends GenericServiceImpl<Accident> implements AccidentService{
    private AccidentRepository accidentRepository;

    @Autowired
    public AccidentServiceImpl(AccidentRepository accidentRepository){
        this.accidentRepository = accidentRepository;
    }

    @Override
    public List<Accident> getAllAccidents() {
        return accidentRepository.findAll();
    }

    @Override
    protected JpaRepository<Accident, Long> getRepository() {
        return accidentRepository;
    }
}
