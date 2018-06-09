package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.ActivitiesSso;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class SPActivityServiceImpl implements SPActivityService{

     @PersistenceContext
    private EntityManager entityManager;

   @Override
    public List<ActivitiesSso> getAllActivities() {
        StoredProcedureQuery query =
                entityManager.createNamedStoredProcedureQuery("sp_get_all_program_sso_activities");

        query.execute();

        return (List<ActivitiesSso>) query.getResultList();
    }

    @Override
    public Boolean deleteActivity(Long idActivity) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_delete_program_sso_activities");
        query.setParameter("sso_detail_id", idActivity);

        query.execute();

        return (Boolean) query.getOutputParameterValue("result");
    }

    @Override
    public Boolean createActivity(ActivitiesSso activitiesSso) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_create_program_sso_activities");
        query.setParameter("sso_detail_activities", activitiesSso.getDetailActivities());
        query.setParameter("sso_detail_goal", activitiesSso.getDetailGoal());
        query.setParameter("sso_detail_number", activitiesSso.getDetailNumber());
        query.setParameter("sso_detail_time", activitiesSso.getDetailTime());
        query.setParameter("sso_detail_type", activitiesSso.getDetailType());
        query.setParameter("sso_id",  activitiesSso.getProgramSso().getId());
        query.setParameter("sso_trainer_id", activitiesSso.getTrainersSso().getId());


        query.execute();

        return (Boolean) query.getOutputParameterValue("result");
    }

    @Override
    public ActivitiesSso updateActivity(Long idActivity, ActivitiesSso activitiesSso) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_edit_program_sso_activities");
        query.setParameter("sso_detail_id", idActivity);
        query.setParameter("sso_detail_activities", activitiesSso.getDetailActivities());
        query.setParameter("sso_detail_goal", activitiesSso.getDetailGoal());
        query.setParameter("sso_detail_number", activitiesSso.getDetailNumber());
        query.setParameter("sso_detail_time", activitiesSso.getDetailTime());
        query.setParameter("sso_detail_type", activitiesSso.getDetailType());
        query.setParameter("sso_id",  activitiesSso.getProgramSso().getId());
        query.setParameter("sso_trainer_id", activitiesSso.getTrainersSso().getId());

        query.execute();

        return (ActivitiesSso) query.getSingleResult();
    }

    @Override
    public ActivitiesSso getActivityById(Long activityId) {
        StoredProcedureQuery  query = entityManager.createNamedStoredProcedureQuery("sp_activityById");
        query.setParameter("sso_detail_id", activityId);

        query.execute();

        return (ActivitiesSso) query.getSingleResult();
    }
}
