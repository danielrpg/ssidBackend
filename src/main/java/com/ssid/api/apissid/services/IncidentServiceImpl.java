package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Incident;
import com.ssid.api.apissid.domain.IncidentDetail;
import com.ssid.api.apissid.domain.IncidentType;
import com.ssid.api.apissid.dto.IncidentDTO;
import com.ssid.api.apissid.repositories.IncidentDetailRepository;
import com.ssid.api.apissid.repositories.IncidentRepository;
import com.ssid.api.apissid.repositories.IncidentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IncidentServiceImpl implements IncidentService {

    private IncidentRepository incidentRepository;
    private IncidentDetailRepository incidentDetailRepository;
    private IncidentTypeRepository incidentTypeRepository;

    @Autowired
    public IncidentServiceImpl(IncidentRepository incidentRepository,
                               IncidentDetailRepository incidentDetailRepository,
                               IncidentTypeRepository incidentTypeRepository) {
        this.incidentRepository = incidentRepository;
        this.incidentDetailRepository = incidentDetailRepository;
        this.incidentTypeRepository = incidentTypeRepository;
    }

    @Override
    public Incident getIncidentById(int id) {
        Optional<Incident> o = incidentRepository.findById((long) id);
        return o.get();
    }

    @Override
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    @Transactional
    @Override
    public Incident createIncident(IncidentDTO incidentDTO) {
        IncidentType incidentType = incidentTypeRepository.findByIncidentTypeName(incidentDTO.getIncidentType());
        IncidentDetail incidentDetail = new IncidentDetail();
        incidentDetail.setIncidentDetailName(incidentDTO.getDescription());

        Incident incident = new Incident();
        incident.setArea(incidentDTO.getArea());
        incident.setCode(incidentDTO.getCode());
        incident.setDateAt(new Date());
        incident.setIncidentNumber(incidentDTO.getIncidentNumber());
        incident.setReincident(incidentDTO.isReincident());
        incident.setReportedBy(incidentDTO.getReportedBy());
        incident.setTreatment(incidentDTO.isTreatment());
        incident.setIncidentType(incidentType);
        incident.setIncidentDetail(incidentDetail);

        incidentDetailRepository.save(incidentDetail);
        incidentRepository.save(incident);
        return incident;
    }

    @Transactional
    @Override
    public boolean updateIncident(IncidentDTO incidentDTO, int id) {
        IncidentType incidentType = incidentTypeRepository.findByIncidentTypeName(incidentDTO.getIncidentType());
        Incident incident = incidentRepository.findById((long)id).get();
        IncidentDetail incidentDetail = incident.getIncidentDetail();
        incidentDetail.setIncidentDetailName(incidentDTO.getDescription());
        incident.setArea(incidentDTO.getArea());
        incident.setCode(incidentDTO.getCode());
        incident.setDateAt(new Date());
        incident.setIncidentNumber(incidentDTO.getIncidentNumber());
        incident.setReincident(incidentDTO.isReincident());
        incident.setReportedBy(incidentDTO.getReportedBy());
        incident.setTreatment(incidentDTO.isTreatment());
        incident.setIncidentType(incidentType);
        incident.setIncidentDetail(incidentDetail);

        incidentDetailRepository.save(incidentDetail);
        Incident incidentSaved = incidentRepository.save(incident);
        if(incidentSaved.getIncidentId() != null) {
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public void deleteIncident(int id) {
        Incident incident = incidentRepository.findById((long) id).get();
        incidentRepository.delete(incident);
    }
}
