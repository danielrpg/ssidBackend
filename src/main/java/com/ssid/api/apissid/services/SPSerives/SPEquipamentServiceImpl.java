package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.Equipament;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service

public class SPEquipamentServiceImpl implements SPEquipamentService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Equipament> getAllEquipaments() {
        StoredProcedureQuery query =
                this.entityManager.createNamedStoredProcedureQuery("sp_getAllEquipament");
        query.execute();
        return (List<Equipament>) query.getResultList();
    }

    @Override
    public void createEquipament(Equipament equipament) {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("sp_createEquipament");
        query.setParameter("equipament_name", equipament.getName());
        query.setParameter("equipament_type", equipament.getType());
        query.setParameter("equipament_description", equipament.getDescription());
        query.setParameter("equipament_image", equipament.getImage());
        query.execute();
    }

    @Override
    public Equipament getEquipamentByID(Long equipamentID){
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("sp_equipamentById");
        query.setParameter("equipament_id", equipamentID);
        query.execute();
        return (Equipament) query.getSingleResult();
    }

    @Override
    public Equipament updateEquipament(Equipament equipament, Long id) {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("sp_editEquipament");
        query.setParameter("equipament_id", equipament.getId());
        query.setParameter("equipament_name", equipament.getName());
        query.setParameter("equipament_type", equipament.getType());
        query.setParameter("equipament_description", equipament.getDescription());
        query.setParameter("equipament_image", equipament.getImage());
        query.execute();
        return (Equipament) query.getSingleResult();
    }

    @Override
    public void deleteEquipament(Long equipamentID) {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("sp_deleteEquipament");
        query.setParameter("equipament_id", equipamentID);
        query.execute();
    }
}
