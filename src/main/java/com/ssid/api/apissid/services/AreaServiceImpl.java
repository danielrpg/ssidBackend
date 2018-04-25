package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Area;
import com.ssid.api.apissid.repositories.AreaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class AreaServiceImpl extends GenericServiceImpl<Area> implements AreaService {
    private AreaRepository repository;

    public AreaServiceImpl(AreaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Area> findByName(String name) {
        return StringUtils.isEmpty(name) ? findAll() : repository.findByName(name).get();
    }

    @Override
    protected JpaRepository<Area, Long> getRepository() {
        return repository;
    }
}
