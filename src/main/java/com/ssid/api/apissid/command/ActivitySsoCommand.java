package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.ActivitiesSso;
import java.util.Date;


public class ActivitySsoCommand {
    private Long activityId;
    private int activityNumber;
    private String activityDetail;
    private String activityGoal;
    private Date activityTime;
    private String activityType;
    private Object[] programSso = new Object[0];

    public ActivitySsoCommand(ActivitiesSso activitiesSso){
        setId(activitiesSso.getId());
        setActivityNumber(activitiesSso.getDetailNumber());
        setActivityDetail(activitiesSso.getDetailActivities());
        setActivityGoal(activitiesSso.getDetailGoal());
        setActivityTime(activitiesSso.getDetailTime());
        setActivityType(activitiesSso.getDetailType());
        setActivityTime(activitiesSso.getDetailTime());
    }

    public ActivitiesSso toActivitiesSso(){
        ActivitiesSso activitiesSso = new ActivitiesSso();
        activitiesSso.setId(getId());
        activitiesSso.setDetailNumber(getActivityNumber());
        activitiesSso.setDetailActivities(getActivityDetail());
        activitiesSso.setDetailGoal(getActivityGoal());
        activitiesSso.setDetailTime(getActivityTime());
        activitiesSso.setDetailType(getActivityType());

        return activitiesSso;
    }

    public Long getId() {
        return activityId;
    }

    public void setId(Long activityId) {
        this.activityId = activityId;
    }


    public int getActivityNumber() {
        return activityNumber;
    }

    public void setActivityNumber(int number) {
        this.activityNumber = number;
    }

    public String getActivityDetail() {return activityDetail;}

    public void setActivityDetail(String activityDetail) {this.activityDetail = activityDetail;}

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityGoal() {
        return activityGoal;
    }

    public void setActivityGoal(String activityGoal) {
        this.activityGoal = activityGoal;
    }

    public Object[] getProgramSso() {
        return programSso;
    }

    public void setProgramSso(Object[] programSso) {
        this.programSso = programSso;
    }
}


