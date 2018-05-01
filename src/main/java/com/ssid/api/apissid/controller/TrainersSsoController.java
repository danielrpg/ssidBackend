package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.ProgramSsoCommand;
import com.ssid.api.apissid.command.TrainersSsoCommand;
import com.ssid.api.apissid.domain.TrainersSso;
import com.ssid.api.apissid.services.TrainersSsoService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TrainersSsoController {
    private TrainersSsoService trainersSsoService;

    public TrainersSsoController(TrainersSsoService trainersSsoService) {
        this.trainersSsoService = trainersSsoService;
    }

    @GetMapping(path = ApiPath.TRAINER_SSO_PATH)
    public List<TrainersSsoCommand> getListTrainersSso() {
        List<TrainersSsoCommand> trainersSsoList = new ArrayList<>();
        trainersSsoService.getTrainerssSso().forEach(trainersSso -> {
            trainersSsoList.add(new TrainersSsoCommand(trainersSso));
        });

        return trainersSsoList;
    }

    @RequestMapping(value = ApiPath.TRAINER_SSO_PATH, method = RequestMethod.POST)
    public @ResponseBody
    TrainersSsoCommand saveTrainersSso(@RequestBody TrainersSsoCommand trainersSsoCommand) {
         return new TrainersSsoCommand(this.trainersSsoService.saveTrainersSso(trainersSsoCommand.toTrainersSso()));
    }

    @RequestMapping(value = ApiPath.TRAINER_BY_ID, method = RequestMethod.GET)
    public @ResponseBody
    TrainersSsoCommand findTrainersSsoById(@PathVariable(value = "id") Long id) {
        if(this.trainersSsoService.getTrainersSsoById(id).isPresent()){
            return new TrainersSsoCommand(this.trainersSsoService.getTrainersSsoById(id).get());
        }
        else {
            return new TrainersSsoCommand();
        }
    }

    @RequestMapping(value = ApiPath.TRAINER_BY_ID, method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteTrainersSsoById(@PathVariable(value = "id") Long id) {
        this.trainersSsoService.deleteTrainersSsoById(id);
    }

    @RequestMapping(value = ApiPath.TRAINER_SSO_PATH, method = RequestMethod.PUT)
    public @ResponseBody
    TrainersSsoCommand updateTrainersSso(@RequestBody TrainersSsoCommand trainersSsoCommand, @PathVariable(value = "id") Long id) {
        return new TrainersSsoCommand(this.trainersSsoService.updateTrainersSso(trainersSsoCommand.toTrainersSso(), id));
    }
}
