package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.ActivitiesSso;
import com.ssid.api.apissid.domain.Personal;
import com.ssid.api.apissid.domain.ResourceSso;

import java.util.ArrayList;
import java.util.Date;


public class ActivitySsoCommand {
    private Long activityId;
    private int activityNumber;
    private String activityDetail;
    private String activityGoal;
    private String activityTime;
    private String activityType;
    private ArrayList<PersonalCommand> personalCommands = new ArrayList<>();
    private ArrayList<ResourcesSsoCommand> resourcesSsoCommands = new ArrayList<>();
    private ProgramSsoCommand programSsoCommand;
    private TrainersSsoCommand trainersSsoCommand;

    public ActivitySsoCommand(ActivitiesSso activitiesSso){
        setId(activitiesSso.getId());
        setActivityNumber(activitiesSso.getDetailNumber());
        setActivityDetail(activitiesSso.getDetailActivities());
        setActivityGoal(activitiesSso.getDetailGoal());
        setActivityTime(activitiesSso.getDetailTime());
        setActivityType(activitiesSso.getDetailType());

        if(activitiesSso.getPersonals() != null &&
                !activitiesSso.getPersonals().isEmpty() &&
                activitiesSso.getPersonals().size() > 0) {
            for (Personal per : activitiesSso.getPersonals()) {
                personalCommands.add(new PersonalCommand(per));
            }
        }

        if(activitiesSso.getResourceSsos() != null &&
                !activitiesSso.getResourceSsos().isEmpty() &&
                activitiesSso.getResourceSsos().size() > 0) {
            for (ResourceSso resourceSso : activitiesSso.getResourceSsos()) {
                resourcesSsoCommands.add(new ResourcesSsoCommand(resourceSso));
            }
        }

        if(activitiesSso.getProgramSso() != null) {
            setProgramSsoCommand(new ProgramSsoCommand(activitiesSso.getProgramSso()));
        }

        if(activitiesSso.getTrainersSso() != null){
            setTrainersSsoCommand(new TrainersSsoCommand(activitiesSso.getTrainersSso()));
        }
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

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
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

    public ArrayList<PersonalCommand> getPersonalCommands() {
        return personalCommands;
    }

    public void setPersonalCommands(ArrayList<PersonalCommand> personalCommands) {
        this.personalCommands = personalCommands;
    }

    public ArrayList<ResourcesSsoCommand> getResourcesSsoCommands() {
        return resourcesSsoCommands;
    }

    public void setResourcesSsoCommands(ArrayList<ResourcesSsoCommand> resourcesSsoCommands) {
        this.resourcesSsoCommands = resourcesSsoCommands;
    }

    public ProgramSsoCommand getProgramSsoCommand() {
        return programSsoCommand;
    }

    public void setProgramSsoCommand(ProgramSsoCommand programSsoCommand) {
        this.programSsoCommand = programSsoCommand;
    }

    public TrainersSsoCommand getTrainersSsoCommand() {
        return trainersSsoCommand;
    }

    public void setTrainersSsoCommand(TrainersSsoCommand trainersSsoCommand) {
        this.trainersSsoCommand = trainersSsoCommand;
    }
}


