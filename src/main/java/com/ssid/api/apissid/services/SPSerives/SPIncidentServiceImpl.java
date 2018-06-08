package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.Incident;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Service
public class SPIncidentServiceImpl implements SPIncidentService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Boolean createIncident(Long incidentDetailId, Long incidentTypeId, Long personalId, Incident incident) {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("sp_createIncident");
        query.setParameter("incident_code", incident.getIncidentCode());
        query.setParameter("incident_number", incident.getIncidentNumber());
        query.setParameter("incident_registered_date", incident.getIncidentRegisteredDate());
        query.setParameter("incident_reincident", incident.isIncidentReincident());
        query.setParameter("incident_treatment", incident.isIncidentTreatment());
        query.setParameter("incident_severity", incident.getIncidentSeverity());
        query.setParameter("incident_reported_by", incident.getIncidentReportedBy());
        query.setParameter("incident_detail_id", incident.getIncidentDetail().getIncidentDetailId());
        query.setParameter("incident_type_id", incident.getIncidentType().getIncidentTypeId());
        query.setParameter("personal_id", incident.getPersonal().getId());

        query.execute();

        return (Boolean) query.getOutputParameterValue("result");
    }
}
