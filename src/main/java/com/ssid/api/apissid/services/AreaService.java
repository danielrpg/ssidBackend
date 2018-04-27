package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Area;
import com.ssid.api.apissid.dto.RequestAreaDTO;

import java.util.List;

/**
 * @author Jesús David Piérola Alvarado
 */
public interface AreaService extends GenericService<Area> {
    List<Area> findByName(String name);
    Area createArea(RequestAreaDTO requestAreaDTO);
    boolean updateArea(RequestAreaDTO requestAreaDTO, Long id);
}
