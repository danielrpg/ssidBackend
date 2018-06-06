package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.Equipament;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service

public class SPEquipamentServiceImpl implements SPEquipamentService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Equipament> getAllEquipaments() {
        System.out.println("desde getEquipaments");
        StoredProcedureQuery query =
                this.entityManager.createNamedStoredProcedureQuery("sp_getAllEquipament");
        query.execute();
        return (List<Equipament>) query.getResultList();
    }

    @Override
    public void createEquipament(Equipament equipament) {
        System.out.println("desde getEquipaments "+"name:  "+equipament.getName()+" desc:  "+
        equipament.getDescription()+" type:"+equipament.getType()+" img:"+equipament.getImage());
        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("sp_createEquipament");
        query.setParameter("equipament_name", equipament.getName());
        query.setParameter("equipament_type", equipament.getType());
        query.setParameter("equipament_description", equipament.getDescription());
        query.setParameter("equipament_image", equipament.getImage());

        query.execute();
        //return (Boolean) query.getOutputParameterValue("result");
    }
}
