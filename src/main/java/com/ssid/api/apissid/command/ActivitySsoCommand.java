package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.ActivitiesSso;
import com.ssid.api.apissid.domain.Personal;
import com.ssid.api.apissid.domain.ResourceSso;

import java.util.ArrayList;


public class ActivitySsoCommand {
    private Long id;
    private String detailActivities;
    private String detailGoal;
    private int detailNumber;
    private String detailTime;
    private String detailType;
    private ProgramSsoCommand programSsoCommand;
    private TrainersSsoCommand trainersSsoCommand;
    private ArrayList<PersonalCommand> personalCommands = new ArrayList<>();
    private ArrayList<ResourcesSsoCommand> resourcesSsoCommands = new ArrayList<>();

    public ActivitySsoCommand(){}

    public ActivitySsoCommand(ActivitiesSso activitiesSso){
        setId(activitiesSso.getId());
        setActivityDetail(activitiesSso.getDetailActivities());
        setActivityGoal(activitiesSso.getDetailGoal());
        //setActivityNumber(activitiesSso.getDetailNumber());
        setActivityType(activitiesSso.getDetailType());
        // setActivityTime(activitiesSso.getDetailTime());


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
                //  resourcesSsoCommands.add(new ResourcesSsoCommand(resourceSso));
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
        activitiesSso.setDetailActivities(getActivityDetail());
        activitiesSso.setDetailGoal(getActivityGoal());
        //activitiesSso.setDetailNumber(getActivityNumber());
        //activitiesSso.setDetailTime(getActivityTime());
        activitiesSso.setDetailType(getActivityType());


        return activitiesSso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long activityId) {
        this.id = activityId;
    }

    public String getActivityDetail() {return detailActivities;}

    public void setActivityDetail(String detailActivities) {this.detailActivities = detailActivities;}


    public String getActivityTime() {
        return detailTime;
    }

    public void setActivityTime(String detailTime) {
        this.detailTime = detailTime;
    }
    public String getActivityType() {
        return detailType;
    }

    public void setActivityType(String detailType) {
        this.detailType = detailType;
    }

    public String getActivityGoal() {
        return detailGoal;
    }

    public void setActivityGoal(String detailGoal) {
        this.detailGoal = detailGoal;
    }

    public int getActivityNumber() {
        return detailNumber;
    }

    public void setActivityNumber(int detailNumber) {
        this.detailNumber = detailNumber;
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


