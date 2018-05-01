package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Position;

import java.util.List;

public interface PositionService extends GenericService<Position> {
    boolean updatePosition(Position position, Long id);
}
