package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Area;

import java.util.List;

/**
 * @author Jesús David Piérola Alvarado
 */
public interface AreaService extends GenericService<Area> {
    List<Area> findByName(String name);

    boolean updateArea(Area area, Long id);
}
