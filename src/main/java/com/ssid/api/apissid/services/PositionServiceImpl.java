package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Position;
import com.ssid.api.apissid.repositories.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{
    private PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository){
        this.positionRepository = positionRepository;

    }

    @Override
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }
}
