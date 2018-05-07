package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.InjuryBody;
import com.ssid.api.apissid.domain.InjuryType;
import com.ssid.api.apissid.repositories.InjuryBodyRepository;
import com.ssid.api.apissid.repositories.InjuryTypeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class InjuryBodyServiceImpl extends GenericServiceImpl<InjuryBody> implements InjuryBodyService{
    private InjuryBodyRepository injuryBodyRepository;

    public InjuryBodyServiceImpl(InjuryBodyRepository injuryBodyRepository) {
        this.injuryBodyRepository = injuryBodyRepository;
    }

    @Override
    protected JpaRepository<InjuryBody, Long> getRepository() {
        return injuryBodyRepository;
    }
}
