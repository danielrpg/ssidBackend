package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.CausingAgent;
import com.ssid.api.apissid.repositories.CausingAgentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CausingAgentServiceImpl extends GenericServiceImpl<CausingAgent> implements CausingAgentService{
    private CausingAgentRepository causingAgentRepository;

    public CausingAgentServiceImpl(CausingAgentRepository causingAgentRepository) {
        this.causingAgentRepository = causingAgentRepository;
    }

    @Override
    protected JpaRepository<CausingAgent, Long> getRepository() {
        return causingAgentRepository;
    }
}
