package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Personal;

import java.util.List;

/**
 * @author Jesús David Piérola Alvarado
 */
public interface PersonalService extends GenericService<Personal> {

    List<Personal> findByName(String name);
}
