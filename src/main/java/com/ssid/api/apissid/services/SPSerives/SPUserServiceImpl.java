package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.UserSystem;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;


@Service
public class SPUserServiceImpl implements SPUserService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserSystem> getAllUsers() {
        StoredProcedureQuery query =
                entityManager.createNamedStoredProcedureQuery("sp_getAllUsers");

        query.execute();

        return query.getResultList();
    }

    @Override
    public Boolean deleteUser(Long idUser) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_deleteUser");
        query.setParameter("user_id", idUser);

        query.execute();

        return (Boolean) query.getOutputParameterValue("result");
    }

    @Override
    public Boolean createUser(UserSystem userSystem) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_createUser");
        query.setParameter("user_name", userSystem.getUsername());
        query.setParameter("user_password", userSystem.getPassword());
        query.setParameter("user_active", userSystem.getUserActive());

        query.execute();

        return (Boolean) query.getOutputParameterValue("result");
    }

    @Override
    public UserSystem updateUser(Long idUser, UserSystem userSystem) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_editUser");
        query.setParameter("user_id", idUser);
        query.setParameter("user_name", userSystem.getUsername());
        query.setParameter("user_password", userSystem.getPassword());
        query.setParameter("user_active", userSystem.getUserActive());

        query.execute();

        return (UserSystem) query.getSingleResult();
    }
}
