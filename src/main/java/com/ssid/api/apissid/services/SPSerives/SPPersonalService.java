package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.Personal;

import java.util.List;

public interface SPPersonalService {

    List<Personal> getAllPersonals();

    Boolean deletePersonal(Long idPersonal);

    Boolean createPersonal(Personal personal);

    Personal updatePersonal(Long idUser, Personal personal);

    Personal getPersonalById(Long personalId);
}
