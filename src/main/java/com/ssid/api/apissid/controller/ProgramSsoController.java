package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.ProgramSsoCommand;
import com.ssid.api.apissid.domain.ProgramSso;
import com.ssid.api.apissid.services.ActivitiesSsoService;
import com.ssid.api.apissid.services.ProgramSsoService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProgramSsoController {
    private ProgramSsoService programSsoService;
    private ActivitiesSsoService activitiesSsoService;

    public ProgramSsoController(ProgramSsoService programSsoService, ActivitiesSsoService activitiesSsoService) {
        this.programSsoService = programSsoService;
        this.activitiesSsoService = activitiesSsoService;
    }

    @GetMapping(path = ApiPath.PROGRAM_SSO_PATH)
    public List<ProgramSsoCommand> getListActivities() {

        List<ProgramSsoCommand> programSsoList = new ArrayList<>();
        programSsoService.getProgramsSso().forEach(programSso -> {
            programSsoList.add(new ProgramSsoCommand(programSso));
        });

        return programSsoList;
    }

    @RequestMapping(value = ApiPath.PROGRAM_SSO_PATH, method = RequestMethod.POST)
    public @ResponseBody
    void saveActivities(@RequestBody ProgramSsoCommand programSsoCommand) {
        this.programSsoService.saveProgramSso(programSsoCommand.toProgramSso());
    }

    @RequestMapping(value = ApiPath.PROGRAM_BY_ID, method = RequestMethod.GET)
    public @ResponseBody
    ProgramSsoCommand findProgramById(@PathVariable(value = "id") Long id){
        if(this.programSsoService.getProgramById(id).isPresent()){
            return new ProgramSsoCommand(this.programSsoService.getProgramById(id).get());
        }
        else {
            return new ProgramSsoCommand();
        }
    }

    @RequestMapping(value = ApiPath.PROGRAM_BY_ID, method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteProgramById(@PathVariable(value = "id") Long id){
        this.programSsoService.deleteProgramById(id);

    }

    @RequestMapping(value = ApiPath.PROGRAM_SSO_PATH, method = RequestMethod.PUT)
    public @ResponseBody
    ProgramSso updateProgram(@RequestBody ProgramSsoCommand programSsoCommand, @PathVariable(value = "id") Long id){
        return this.programSsoService.updateProgram(programSsoCommand.toProgramSso(), id);
    }
}
