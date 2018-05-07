package com.ssid.api.apissid.services;

import com.ssid.api.apissid.command.PersonalAreaCommand;
import com.ssid.api.apissid.command.PersonalResponseCommand;
import com.ssid.api.apissid.domain.Personal;

import java.io.InputStream;
import java.util.List;

/**
 * @author Jesús David Piérola Alvarado
 */
public interface PersonalService extends GenericService<Personal> {
    List<Personal> findByName(String name);

    boolean updatePersonal(Personal personal, Long id);

    void saveImage(Long id, InputStream inputStream);

    Personal savePersonal(PersonalAreaCommand personal);

    PersonalResponseCommand getPersonalById(Long id);

    Personal updatePersonalArea(PersonalAreaCommand personalResponseCommand, Long id);

    List<Personal> getListPersonals();
}
