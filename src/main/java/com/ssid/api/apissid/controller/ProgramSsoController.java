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
        programSsoService.getProgramsSso().forEach(employee -> {
            programSsoList.add(new ProgramSsoCommand(employee));
        });

       /* Response.ResponseBuilder responseBuilder = Response.ok(programSsoList);
        addCorsHeader(responseBuilder);
        return responseBuilder.build();*/

        return programSsoList;
    }

    @RequestMapping(value = ApiPath.PROGRAM_SSO_PATH, method = RequestMethod.POST)
    public @ResponseBody
    void saveActivities(@RequestBody ProgramSso programSso) {
        this.programSsoService.saveProgramSso(programSso);
    }

    @RequestMapping(value = ApiPath.PROGRAM_BY_ID, method = RequestMethod.GET)
    public @ResponseBody
    Optional<ProgramSso> findProgramById(@PathVariable(value = "id") Long id){
        return this.programSsoService.getProgramById(id);
    }

    @RequestMapping(value = ApiPath.PROGRAM_BY_ID, method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteProgramById(@PathVariable(value = "id") Long id){
        this.programSsoService.deleteProgramById(id);

    }

    @RequestMapping(value = ApiPath.PROGRAM_SSO_PATH, method = RequestMethod.PUT)
    public @ResponseBody
    ProgramSso updateProgram(@RequestBody ProgramSso programSso, @PathVariable(value = "id") Long id){
        return this.programSsoService.updateProgram(programSso, id);
    }
}
