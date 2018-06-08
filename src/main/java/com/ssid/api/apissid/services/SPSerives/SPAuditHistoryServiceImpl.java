package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.AuditHistory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.swing.text.StringContent;
import java.util.List;

@Service
public class SPAuditHistoryServiceImpl implements SPAuditHistoryService{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<AuditHistory> getAllAuditHistory() {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("sp_AuditHistoryAll");
        query.execute();

        return (List<AuditHistory>) query.getResultList();
    }

    @Override
    public List<AuditHistory> getAuditHistory(String date, String date1) {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("sp_AuditHistory");
        query.setParameter("start_date", date);
        query.setParameter("end_date", date1);
        query.execute();

        return (List<AuditHistory>) query.getResultList();
    }


}
