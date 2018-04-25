package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.ProgramSso;
import com.ssid.api.apissid.services.ProgramSsoService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProgramSsoController {
    private ProgramSsoService programSsoService;

    public ProgramSsoController(ProgramSsoService programSsoService) {
        this.programSsoService = programSsoService;
    }

    @GetMapping(path = ApiPath.PROGRAM_SSO_PATH)
    public List<ProgramSso> getListActivities() {
        return this.programSsoService.getProgramsSso();
    }

    @RequestMapping(value = ApiPath.PROGRAM_SSO_PATH, method = RequestMethod.POST)
    public @ResponseBody
    void saveActivities(@RequestBody ProgramSso programSso) {
        this.programSsoService.saveProgramSso(programSso);
    }
}
