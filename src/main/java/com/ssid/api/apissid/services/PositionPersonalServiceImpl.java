package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.PositionPersonal;
import com.ssid.api.apissid.repositories.PositionPersonalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionPersonalServiceImpl implements PositionPersonalService{
    private PositionPersonalRepository positionPersonalRepository;

    public PositionPersonalServiceImpl(PositionPersonalRepository positionPersonalRepository){
        this.positionPersonalRepository = positionPersonalRepository;
    }
    @Override
    public List<PositionPersonal> getAllPositionPersonal() {
        return this.positionPersonalRepository.findAll();
    }
}
