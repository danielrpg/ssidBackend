package com.ssid.api.apissid.services;

import com.ssid.api.apissid.domain.Incident;
import com.ssid.api.apissid.domain.IncidentDetail;
import com.ssid.api.apissid.domain.IncidentType;
import com.ssid.api.apissid.domain.Personal;
import com.ssid.api.apissid.dto.IncidentDTO;
import com.ssid.api.apissid.repositories.IncidentDetailRepository;
import com.ssid.api.apissid.repositories.IncidentRepository;
import com.ssid.api.apissid.repositories.IncidentTypeRepository;
import com.ssid.api.apissid.repositories.PersonalRepository;
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
    private PersonalRepository personalRepository;

    @Autowired
    public IncidentServiceImpl(IncidentRepository incidentRepository,
                               IncidentDetailRepository incidentDetailRepository,
                               IncidentTypeRepository incidentTypeRepository,
                               PersonalRepository personalRepository) {
        this.incidentRepository = incidentRepository;
        this.incidentDetailRepository = incidentDetailRepository;
        this.incidentTypeRepository = incidentTypeRepository;
        this.personalRepository = personalRepository;
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
        IncidentType incidentType = incidentTypeRepository.findByIncidentTypeName(incidentDTO.getIncidentTypeName());
        Optional<Personal> personal = personalRepository.findById(Long.parseLong(incidentDTO.getReportedBy()));
        IncidentDetail incidentDetail = new IncidentDetail();
        incidentDetail.setIncidentDetailName(incidentDTO.getDescription());
        incidentDetail.setIncidentDetailDescription("");
        incidentDetail.setIncidentDetailStatus(incidentDTO.getStatus());

        Incident incident = new Incident();
        //incident.setArea(incidentDTO.getArea());
        incident.setIncidentCode(incidentDTO.getCode());
        incident.setIncidentRegisteredDate(new Date());
        incident.setIncidentNumber(incidentDTO.getIncidentNumber());
        incident.setIncidentReincident(incidentDTO.isReincident());
        incident.setIncidentReportedBy(incidentDTO.getReportedBy());
        incident.setIncidentNumber(incidentDTO.getIncidentNumber());
        incident.setIncidentTreatment(incidentDTO.isTreatment());
        incident.setIncidentSeverity(incidentDTO.getSeverity());
        incident.setIncidentType(incidentType);
        incident.setIncidentDetail(incidentDetail);
        incident.setPersonal(personal.get());

        incidentDetailRepository.save(incidentDetail);
        incidentRepository.save(incident);
        return incident;
    }

    @Transactional
    @Override
    public boolean updateIncident(IncidentDTO incidentDTO, int id) {
        IncidentType incidentType = incidentTypeRepository.findByIncidentTypeName(incidentDTO.getIncidentTypeName());
        Incident incident = incidentRepository.findById((long)id).get();
        Personal personal = personalRepository.getOne(Long.parseLong(incidentDTO.getReportedBy()));
        IncidentDetail incidentDetail = incident.getIncidentDetail();
        incidentDetail.setIncidentDetailName(incidentDTO.getDescription());
        incidentDetail.setIncidentDetailDescription("");
        //incident.setArea(incidentDTO.getArea());
        incident.setIncidentCode(incidentDTO.getCode());
        incident.setIncidentSeverity(incidentDTO.getSeverity());
        incident.setIncidentRegisteredDate(new Date());
        incident.setIncidentNumber(incidentDTO.getIncidentNumber());
        incident.setIncidentReincident(incidentDTO.isReincident());
        incident.setIncidentReportedBy(incidentDTO.getReportedBy());
        incident.setIncidentTreatment(incidentDTO.isTreatment());
        incident.setIncidentType(incidentType);
        incident.setIncidentDetail(incidentDetail);
        incident.setPersonal(personal);

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
