package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.Personal;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class SPPersonalServiceImpl implements SPPersonalService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Personal> getAllPersonals() {
        StoredProcedureQuery query =
                entityManager.createNamedStoredProcedureQuery("sp_getAllPersonal");

        query.execute();

        return (List<Personal>) query.getResultList();
    }

    @Override
    public Boolean deletePersonal(Long idPersonal) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_deletePersonal");
        query.setParameter("personal_id", idPersonal);

        query.execute();

        return (Boolean) query.getOutputParameterValue("result");
    }

    @Override
    public Boolean createPersonal(Personal personal) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_createPersonal");
        query.setParameter("personal_name", personal.getName());
        query.setParameter("personal_last_name", personal.getLastName());
        query.setParameter("personal_email", personal.getEmail());
        query.setParameter("personal_direction", personal.getAddress());
        query.setParameter("personal_cellphone", personal.getCellphone());
        query.setParameter("personal_telephone", personal.getCellphone());
        query.setParameter("personal_active", true);
        query.setParameter("area_id", personal.getArea().getId());


        query.execute();

        return (Boolean) query.getOutputParameterValue("result");
    }

    @Override
    public Personal updatePersonal(Long idPersonal, Personal personal) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_editPersonal");
        query.setParameter("personal_id", idPersonal);
        query.setParameter("personal_name", personal.getName());
        query.setParameter("personal_last_name", personal.getLastName());
        query.setParameter("personal_email", personal.getEmail());
        query.setParameter("personal_direction", personal.getAddress());
        query.setParameter("personal_cellphone", personal.getCellphone());
        query.setParameter("personal_telephone", personal.getCellphone());
        query.setParameter("personal_active", true);
        query.setParameter("area_id", personal.getArea().getId());

        query.execute();

        return (Personal) query.getSingleResult();
    }

    @Override
    public Personal getPersonalById(Long personalId) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_personalById");
        query.setParameter("personal_id", personalId);

        query.execute();

        return (Personal) query.getSingleResult();
    }
}
