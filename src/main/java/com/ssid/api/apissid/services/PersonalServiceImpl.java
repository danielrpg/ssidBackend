package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Personal;
import com.ssid.api.apissid.repositories.PersonalRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Jesus David Piérola Alvarado
 */
@Service
public class PersonalServiceImpl extends GenericServiceImpl<Personal> implements PersonalService {

    private PersonalRepository repository;

    public PersonalServiceImpl(PersonalRepository personalRepository) {
        this.repository = personalRepository;
    }

    @Override
    public List<Personal> findByName(String name) {
        return StringUtils.isEmpty(name) ? findAll() : repository.findByName(name).get();
    }

    @Override
    protected JpaRepository<Personal, Long> getRepository() {
        return repository;
    }
}
