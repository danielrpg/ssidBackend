package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Personal;
import com.ssid.api.apissid.repositories.PersonalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author daniel fernandez
 */
@Service
public class PersonalServiceImpl implements PersonalService{

    private PersonalRepository personalRepository;

    public PersonalServiceImpl(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    @Override
    public List<Personal> getListPersonal() {
        return this.personalRepository.findAll();
    }
}
