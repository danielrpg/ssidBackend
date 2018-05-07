package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.InjuryForm;
import com.ssid.api.apissid.repositories.InjuryFormRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class InjuryFormServiceImpl extends GenericServiceImpl<InjuryForm> implements InjuryFormService{
    private InjuryFormRepository injuryFormRepository;

    public InjuryFormServiceImpl(InjuryFormRepository injuryFormRepository) {
        this.injuryFormRepository = injuryFormRepository;
    }

    @Override
    protected JpaRepository<InjuryForm, Long> getRepository() {
        return injuryFormRepository;
    }
}
