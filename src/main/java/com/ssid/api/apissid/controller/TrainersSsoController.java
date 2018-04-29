package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.TrainersSso;
import com.ssid.api.apissid.services.TrainersSsoService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TrainersSsoController {
    private TrainersSsoService trainersSsoService;

    public TrainersSsoController(TrainersSsoService trainersSsoService) {
        this.trainersSsoService = trainersSsoService;
    }

    @GetMapping(path = ApiPath.TRAINER_SSO_PATH)
    public List<TrainersSso> getListTrainersSso() {
        return this.trainersSsoService.getTrainerssSso();
    }

    @RequestMapping(value = ApiPath.TRAINER_SSO_PATH, method = RequestMethod.POST)
    public @ResponseBody
    TrainersSso saveTrainersSso(@RequestBody TrainersSso trainersSso) {
         return this.trainersSsoService.saveTrainersSso(trainersSso);
    }

    @RequestMapping(value = ApiPath.TRAINER_BY_ID, method = RequestMethod.GET)
    public @ResponseBody
    Optional<TrainersSso> findTrainersSsoById(@PathVariable(value = "id") Long id) {
        return this.trainersSsoService.getTrainersSsoById(id);
    }

    @RequestMapping(value = ApiPath.TRAINER_BY_ID, method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteTrainersSsoById(@PathVariable(value = "id") Long id) {
        this.trainersSsoService.deleteTrainersSsoById(id);
    }

    @RequestMapping(value = ApiPath.TRAINER_SSO_PATH, method = RequestMethod.PUT)
    public @ResponseBody
    TrainersSso updateTrainersSso(@RequestBody TrainersSso trainersSso, @PathVariable(value = "id") Long id) {
        return this.trainersSsoService.updateTrainersSso(trainersSso, id);
    }
}
