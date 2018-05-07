package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.InjuryForm;
import com.ssid.api.apissid.domain.InjuryType;
import com.ssid.api.apissid.repositories.InjuryTypeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class InjuryTypeServiceImpl extends GenericServiceImpl<InjuryType> implements InjuryTypeService{
    private InjuryTypeRepository incidentTypeRepository;

    public InjuryTypeServiceImpl(InjuryTypeRepository incidentTypeRepository) {
        this.incidentTypeRepository = incidentTypeRepository;
    }

    @Override
    protected JpaRepository<InjuryType, Long> getRepository() {
        return incidentTypeRepository;
    }
}
